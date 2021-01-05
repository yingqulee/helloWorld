package Base_JAVA.base_23;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class demo_UploadServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);

        while(true){
            Socket socket = server.accept();

            //使用多线程提高程序效率
            new Thread(new Runnable() {
                //有一个客户端上传文件,就开启一个线程
                @Override
                public void run() {
                    FileOutputStream fos = null;

                    try{
                        InputStream is = socket.getInputStream();

                        File file = new File("F:\\黑马IDEA教程\\upload");
                        if (!file.exists()){
                            file.mkdir();
                        }

                        //优化一:自定义一个文件命名规则:防止同名的文件被覆盖
                        String filename = "test"+System.currentTimeMillis()+new Random().nextInt(99999)+".jpg";

                        fos = new FileOutputStream(file+"\\"+filename);

                        int len;
                        byte[] bytes = new byte[1024];
                        while((len = is.read(bytes))!=-1){
                            fos.write(bytes,0,len);
                        }

                        socket.getOutputStream().write("上传成功".getBytes());

                    }catch (IOException e){
                        System.out.println(e);
                    }finally {
                        try {
                            fos.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }
        //服务器不用关闭了
        //server.close();
    }
}
