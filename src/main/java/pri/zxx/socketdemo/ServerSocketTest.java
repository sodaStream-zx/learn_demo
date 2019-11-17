package pri.zxx.socketdemo;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-11-17-15:26
 */
public class ServerSocketTest {
    public static void main(String[] args) throws IOException {
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        ServerSocket serverSocket = new ServerSocket(8080, 1, byName);
        while (!serverSocket.isClosed()) {
            Socket accept = serverSocket.accept();
            String s = new String(IOUtils.toByteArray(accept.getInputStream()));
            System.out.println("s" + s);
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("hello socket resp".getBytes());
            outputStream.flush();
        }
    }
}
