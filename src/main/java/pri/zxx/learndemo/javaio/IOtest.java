package pri.zxx.learndemo.javaio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-03-17-22:31
 */
public class IOtest {
    public static void readFile() {
        String uri = "C:\\Users\\11398\\Desktop\\RabbitMQ.pdf";
        File doc = new File(uri);
        if (doc.exists()) {
            try {
                System.out.println("length：：" + doc.length());
                BufferedInputStream is = new BufferedInputStream(new FileInputStream(uri));
                byte[] cons = new byte[(int) doc.length()];
                is.read(cons);
                System.out.println("文件大小：" + new String(cons).getBytes().length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在");
        }
    }

    public static void main(String[] args) {
        IOtest.readFile();
    }
}
