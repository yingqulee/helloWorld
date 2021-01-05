package Base_JAVA.base_23;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
    文件上传案列-服务器端:读取客户端上传的文件,保存到服务器的硬盘,给客户端会写:上传成功

    数据源:客户端上传的文件
    目的地:服务器的硬盘

    实现步骤:
        1.创建一个服务器ServerSocket对象,和系统要指定的端口号
        2.使用ServerSocket对象中的方法accept,获取到请求的客户端Socket对象
        3.使用Socket对象中的方法getInputStream,获取到网络字节输入流InputStream对象
        4.判断目的地中文件是否存在,不存在则创建
        5.创建一个本地字节输出流FileOutputStream对象,构造方法中绑定要输出的目的地
        6.使用网络字节输入流InputStream对象中的方法read,读取客户端上传的文件
        7.使用本地字节输出流FileOutputStream对象中的方法write,把读取到的文件保存到服务器的的硬盘上
        8.使用Socket对象中的方法getOutputStream,获取到网络字节输出流OutputStream对象
        9.使用网络字节输出流OutputStream对象中的方法write,给客户端回写:上传成功
        10.释放资源(FileOutputStream,Socket,ServerSocket)
 */
public class demo_UploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);

        Socket socket = server.accept();

        InputStream is = socket.getInputStream();

        File file = new File("F:\\黑马IDEA教程\\upload");
        if (!file.exists()){
            file.mkdir();
        }

        //优化一:自定义一个文件命名规则:防止同名的文件被覆盖
        String filename = "test"+System.currentTimeMillis()+new Random().nextInt(99999)+".jpg";

        FileOutputStream fos = new FileOutputStream(file+"\\"+filename);

        int len;
        byte[] bytes = new byte[1024];
        while((len = is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        socket.getOutputStream().write("上传成功".getBytes());

        fos.close();
        socket.close();
        server.close();
    }
}
