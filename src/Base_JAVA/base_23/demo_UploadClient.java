package Base_JAVA.base_23;

import java.io.*;
import java.net.Socket;

/*
    文件上传案列-客户端:读取本地的文件,上传到服务器,读取服务器回写的数据

    数据源:本地
    目的地:服务器

    实现步骤:
        1.创建一个本地字节输入流FileInputStream对象,构造方法中的绑定要读取的数据源
        2.创建一个客户端Socket对象,构造方法中邦迪服务器的IP地址和端口号
        3.使用Socket中的方法getOutputStream,获取网络字节输出流OutputStream对象
        4.使用本地字节输入流FileInputStream对象中的方法read,把读取到的文件上传到服务器中
        5.使用网络字节输出流OutputStream对象中的方法write,把读取到的文件上传到服务器
        6.使用Socket中的方法getInputStream,获取网络字节输入流InputStream对象
        7.使用网络字节输入流InputStream对象中的方法read,读取服务器回写的数据
        8.释放资源(FileInputStream,Socket)
 */
public class demo_UploadClient {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\15955\\Pictures\\Screenshots\\屏幕截图(25).png");

        Socket socket = new Socket("localhost",8888);

        OutputStream os = socket.getOutputStream();

        int len;
        byte[] bytes = new byte[1024];
        while((len = fis.read(bytes))!= -1){
            os.write(bytes,0,len);
        }

        //写完了数据之后，调用shutdownOutput()方法。不然会死循环
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        while((len = is.read(bytes))!= -1){
            System.out.println(new String(bytes,0,len));
        }

        fis.close();
        socket.close();

    }
}
