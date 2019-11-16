package pri.zxx.learndemo.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

/**
 * @author jason
 * <p>
 * Dec o4, 2018
 */
@Component
public class JwtTokenFactory {

    public static String signingKey = "test";
    private static Logger log = LoggerFactory.getLogger(JwtTokenFactory.class);

    /**
     * 生成token
     *
     * @param userInfo
     * @return
     */
    public static String createAccessJwtToken(UserInfo userInfo, long expirationTime) {
        if (StringUtils.isBlank(userInfo.getMobilephone())) {
            throw new IllegalArgumentException("Cannot create JWT Token without mobilephone");
        }

        Claims claims = Jwts.claims().setSubject(userInfo.getMobilephone() + ":" + userInfo.getId() + ":" + userInfo.getUserType());

        LocalDateTime currentTime = LocalDateTime.now();

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(currentTime
                        .plusMinutes(expirationTime)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact();

        return token;
    }


    /**
     * 解析Token，同时也能验证Token，当验证失败返回null
     *
     * @param jwt
     * @param signKey
     * @return
     */
    public static Map<String, Object> parseJavaWebToken(String jwt, String signKey) {
        try {
            Map<String, Object> jwtClaims =
                    Jwts.parser().setSigningKey(getKeyInstance(signKey)).parseClaimsJws(jwt).getBody();
            return jwtClaims;
        } catch (Exception e) {
            log.error("json web token verify failed" + e.getMessage() + "::" + e.getCause());
            return null;
        }
    }

    private static Key getKeyInstance(String signKey) {
        // We will sign our JavaWebToken with our ApiKey secret
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(signKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }
}
