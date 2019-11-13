package pri.zxx.learndemo.justTest;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Twilight
 */
public class PcAction {

    public static void load() throws IOException {
        String strUrl = "https://baijiahao.baidu.com/s?id=1589546094825996322&wfr=spider&for=pc";
        byte[] cons = new byte[0];
        try {
            URL url = new URL(strUrl);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int index;
            while ((index = is.read()) != -1) {
                bos.write(index);
            }
            cons = bos.toByteArray();
            bos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File html = new File("c:/ceshi.html");
        FileOutputStream fileOutputStream = new FileOutputStream(html);
        fileOutputStream.write(cons);
        fileOutputStream.close();

        //String content = new String(cons, "UTF-8");
        // System.out.println(content);
    }

    public static void main(String[] args) throws IOException {
        PcAction.load();
    }
}
