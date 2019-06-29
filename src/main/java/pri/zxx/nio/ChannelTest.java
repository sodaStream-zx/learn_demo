package pri.zxx.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Twilight
 * @desc 通道测试
 * @createTime 2019-06-29-23:09
 */
public class ChannelTest {
    @Test
    public void myTest() throws IOException {
        //FileChanel SocketChannel ServerSocketChannel FataGramChannel
        //支持通道的类提供了getChannel()
        //本地io fileInp FileOutP RandomAccessFile
        // jdk 1.7后 静态方法 open （）
        // Files工具类 newByteChannel()
        FileInputStream fileInputStream = new FileInputStream("files/log4j.properties");
        FileOutputStream fo = new FileOutputStream("files/lo.properties");
        FileChannel in = fileInputStream.getChannel();
        FileChannel out = fo.getChannel();
        ByteBuffer bug = ByteBuffer.allocate(1024);
        while (in.read(bug) != -1) {
            bug.flip();
            out.write(bug);
            bug.clear();
        }
        out.close();
        in.close();
        fo.close();
        fileInputStream.close();
    }

    @Test
    public void myTest2() throws IOException {
        //物理内存缓存 （内存映射文件）
        FileChannel open = FileChannel.open(Paths.get("files/lo.properties"), StandardOpenOption.READ);

    }
}
