package pri.zxx.socketdemo;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-11-17-15:09
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);
        out.println("hello socket!!");
        out.flush();

        byte[] bytes = IOUtils.toByteArray(socket.getInputStream());
        System.out.println(new String(bytes));
        socket.close();

    }
}
