package Base_JAVA.base_23;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    java.net.ServerSocket代表服务器。

    构造方法：
    public ServerSocket(int port)：参数只有一个端口号。

    常用方法：
    public Socket accept()：一旦调用就会阻塞，直到有人连接我，返回一个对应的Socket对应。
    public void close()：关闭

    步骤：
    1. 创建一个ServerSocket对象，并且指定服务器的端口号。
    2. 调用accept方法，获取一个客户端连接（图中的Socket'撇儿）
    3. 通过getInputStream方法，获取一个字节输入流，读取客户端发来的消息。
    4. 通过getOutputStream方法，获取一个字节输出流，给客户端发消息。
    5. 关闭。（可以先关闭一个Socket连接，然后再关闭大服务器；也可以直接关闭大服务器。）
*/
public class demo_TCPServer {

    public static void main(String[] args) throws IOException {
        // 首先创建服务器对象，只需要指定端口号就可以。
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器已经启动");

        Socket client = server.accept();
        System.out.println("服务器已经收到了一个连接");

        // 根据对应的Socket'获取了一个字节输入流，用来读取客户端发来的消息
        InputStream in = client.getInputStream();

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1) {
            System.out.println("服务器收到：" + new String(buf, 0, len));
        }

        // 根据对应的Socket'再获取一个字节输出流，用来给客户端发送响应数据。
        OutputStream out = client.getOutputStream();
        out.write("你也好".getBytes());

        client.close();
        server.close();
        System.out.println("服务器已经关闭");
    }
}
