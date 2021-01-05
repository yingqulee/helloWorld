package Base_JAVA.base_23;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
    java.net.Socket代表客户端。

    构造方法：
    public Socket(String host, int port)：第一个参数代表服务器的IP地址，第二的参数代表服务器的端口号

    常用方法：
    public OutputStream getOutputStream()：获取字节输出流，用来写数据，发送数据
    public InputStream getInputStream()：获取字节输入流，用来读数据，接收数据
    public void close()：关闭socket连接
    public void shutdownOutput()：关闭输出流，并且发送结束标记，但是连接不断。

    步骤：
    1. 创建Socket对象，指定IP地址和端口号。只要创建了对象，就算连接建立了。
    2. 获取字节输出流，调用getOutputStream()，然后再write()方法。
    3. 获取字节输入流，调用getInputStream()，然后再read()方法。
    4. 关闭连接（没有必要单独关闭Input和Output，只要关闭了Socket，里面的In和Out都会自动关闭）。
*/
public class demo_TCPClient {

    public static void main(String[] args) throws IOException {
        // 创建一个Socket对象，指定服务器的IP地址和服务器的端口号
        // 127.0.0.1代表当前计算机自己，也可以写成localhost
        Socket socket = new Socket("localhost", 8888);
        System.out.println("客户端已经启动");

        // 获取字节输出流，把字节数据写给服务器，发送给服务器
        OutputStream out = socket.getOutputStream();
        // 将数据发送给服务器
        out.write("Hello".getBytes());
        socket.shutdownOutput(); // 关闭输出流，并且发送EOF结束标记
        System.out.println("客户端发送数据完毕");

        // 获取字节输入流，读取服务器的响应数据
        InputStream in = socket.getInputStream();

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1) {
            System.out.println("客户端收到：" + new String(buf, 0, len));
        }
        socket.close(); // 关闭连接
        System.out.println("客户端关闭");
    }
}
