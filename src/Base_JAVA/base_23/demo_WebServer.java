package Base_JAVA.base_23;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    创建一个BS版本TCP服务器
 */

//失败---->解析不了客户端请求的消息
public class demo_WebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while(true){
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        InputStream is = socket.getInputStream();

                        /*byte[] bytes = new byte[1024];
                        int len;
                        while((len = is.read(bytes))!= -1){
                            System.out.println(new String(bytes,0,len));
                        }*/

                        //读第一行就行:GET /base_23/web/index.html HTTP/1.1
                        //把is网络字节输入流对象,转换为字符缓冲输入流
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        String line = br.readLine();

                        String[] arr = line.split(" ");
                        String htmlPath = arr[1].substring(1);
                        //创建一个本地字节输入流,构造方法中绑定要读取的html路径
                        FileInputStream fis = new FileInputStream(htmlPath);

                        //使用socket方法getOutputStream获取网络字节输出流OutputStream对象
                        OutputStream os = socket.getOutputStream();

                        //写入HTTP协议响应头,固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content‐Type:text/html\r\n".getBytes());
                        //必须要写入空行,否则浏览器不解析
                        os.write("\r\n".getBytes());

                        //把服务器读取的html文件回写到客户端
                        byte[] bytes = new byte[1024];
                        int len;
                        while((len = fis.read(bytes))!= -1){
                            os.write(bytes,0,len);
                        }

                        fis.close();
                        socket.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }

        //server.close();
    }
}
