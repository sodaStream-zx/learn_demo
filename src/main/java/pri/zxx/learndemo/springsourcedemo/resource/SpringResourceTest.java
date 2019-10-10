package pri.zxx.learndemo.springsourcedemo.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

import java.io.*;

/**
 * @author zxx
 * @desc
 * @createTime 2019-10-10-上午 9:37
 */
public class SpringResourceTest {

    /**
     * desc: spring框架 文件资源
     *
     * @Return: void
     **/
    private static void fileResourceTest(String path) throws IOException {
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        String filename = fileSystemResource.getFilename();
        System.out.println(filename);
        System.out.println(fileSystemResource.lastModified());
        System.out.println(fileSystemResource.getDescription());
        InputStream inputStream = fileSystemResource.getInputStream();
        streamPrintln(inputStream);
    }

    /**
     * desc: spring框架 url资源  无法获取js加载的html文件内容 请求参数不灵活
     *
     * @Return: void
     **/
    private static void urlResourceTest(String url) throws IOException {
        UrlResource urlResource = new UrlResource(url);
        System.out.println(urlResource.getDescription());
        InputStream inputStream = urlResource.getInputStream();
        byte[] bytes = IOUtils.toByteArray(inputStream);
        File html = new File("myfiles/ht2.html");
        if (!html.exists()) {
            html.createNewFile();
        }
        OutputStream out = new FileOutputStream(html);
        out.write(bytes);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        String path = "myfiles/活动列表字段.txt";
        String url = "https://blog.csdn.net/qq_26932225/article/category/8622266";
        String url2 = "http://10.253.50.31:8848/nacos/#/configurationManagement?dataId=&group=&appName=&namespace=";
        fileResourceTest(path);
        System.out.println("##########################################################################");
//        urlResourceTest(url);
        urlResourceTest(url2);
    }

    private static void streamPrintln(InputStream inputStream) throws IOException {
        System.out.println(new String(IOUtils.readFully(inputStream, inputStream.available())));
    }
}
