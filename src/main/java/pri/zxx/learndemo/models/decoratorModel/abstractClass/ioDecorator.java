package pri.zxx.learndemo.models.decoratorModel.abstractClass;

import java.io.*;

/**
 * desc: io装饰着模式
 *
 * @Return:
 **/
public class ioDecorator extends FilterInputStream {
    //偏移量
    private int offset;

    //接收一个输入流
    protected ioDecorator(InputStream in) {
        super(in);
    }

    public static void main(String[] args) {
        int c;
        String pathname = "C:\\Users\\lenovo\\Desktop\\DecoratorTest.txt";
        File file = new File(pathname);
        try {
            InputStream inputStream = new ioDecorator(new BufferedInputStream(new FileInputStream(file)));
            while ((c = inputStream.read()) >= 0) {
                System.out.print((char) c);
                //System.out.print(c);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toUpperCase((char) c));
    }

    //转换输入的字符为小写/大写
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        }
        return super.read(b, off, len);
    }
}
