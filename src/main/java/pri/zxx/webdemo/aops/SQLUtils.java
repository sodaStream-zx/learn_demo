package pri.zxx.webdemo.aops;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 钢蛋
 * @desc sql组装 修饰
 * @createTime 2020-03-31-10:09
 */
public class SQLUtils {
    /**
     * 获取Insert语句后面values 参数信息<br>
     */
    public static String[] sqlInsertParameter(String sql) {
        int startIndex = sql.indexOf("values");
        int endIndex = sql.length();
        String substring = sql.substring(startIndex + 6, endIndex).replace("(", "").replace(")", "").replace("#{", "")
                .replace("}", "");
        return substring.split(",");
    }

    /**
     * 获取select 后面where语句
     */
    public static List<String> sqlSelectParameter(String sql) {
        int startIndex = sql.indexOf("where");
        int endIndex = sql.length();
        String substring = sql.substring(startIndex + 5, endIndex);
        String[] split = substring.split("and");
        List<String> listArr = new ArrayList();
        for (String string : split) {
            String[] sp2 = string.split("=");
            listArr.add(sp2[0].trim());
        }
        return listArr;
    }

    /**
     * 将SQL语句的参数替换变为?<br>
     */
    public static String parameQuestion(String sql, String[] parameterName) {
        for (String string : parameterName) {
            sql = sql.replace("#{" + string + "}", "?");
        }
        return sql;
    }

    public static String parameQuestion(String sql, List<String> parameterName) {
        for (String string : parameterName) {
            sql = sql.replace("#{" + string + "}", "?");
        }
        return sql;
    }


    public static void main(String[] args) {

        // String[] sqlParameter = sqlInsertParameter(sql);
        // for (String string : sqlParameter) {
        // System.out.println(string);
        // }

    }
}


