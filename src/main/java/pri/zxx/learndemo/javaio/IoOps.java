package pri.zxx.learndemo.javaio;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author zxx
 * @desc
 * @createTime 2019-08-20-下午 2:13
 */
public class IoOps {
    private static final Logger log = LoggerFactory.getLogger(IoOps.class);

    //InputStream OutStream
    @Test
    public void ioTest1() throws IOException {
        String theFile = "myfiles/活动列表字段.txt";
        InputStream inputStream = new FileInputStream(theFile);
        byte[] thePot = new byte[inputStream.available()];
        boolean b = inputStream.markSupported();
        System.out.println("canMark?" + b);
        inputStream.read(thePot);
        System.out.println(new String(thePot, StandardCharsets.UTF_8));
//        int read = 0;
//        while (read != -1) {
//            read = inputStream.read(thePot);
//            System.out.println(new String(thePot, "utf-8"));
//            log.warn("size:{} ", thePot.length);
//        }
        inputStream.close();
    }
}
