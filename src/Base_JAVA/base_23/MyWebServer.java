package Base_JAVA.base_23;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer {

    private static final String SEP = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器已经启动");

        while (true) {
            Socket client = server.accept();

            // 单独通过一个方法，根据Socket客户端对象，从而得到对应的文件路径
            String path = getRequestPath(client);
            if (path.toLowerCase().endsWith("favicon.ico")) {
                continue;
            }

            OutputStream netOut = client.getOutputStream();

            netOut.write(("HTTP/1.1 200 OK" + SEP).getBytes()); // 第一行必须这么写才算HTTP请求成功
            netOut.write(("Content-Type:text/html" + SEP + SEP).getBytes()); // 第二行内容也算固定，第三行保持空白
            // 已经有两行内容，第三行空白，从继续后面的第四行开始，就是真正的业务数据了。

            FileInputStream localIn = new FileInputStream(path);
            byte[] buf = new byte[1024];
            int len;
            while ((len = localIn.read(buf)) != -1) {
                netOut.write(buf, 0, len);
            }
            localIn.close();

            client.close();
        }
    }

    /*
    这个方法专门用来根据客户端Socket对象，读取其中的第一行。
    根据第一行的格式，拿到中间部分，代表需要请求的文件路径名。
     */
    private static String getRequestPath(Socket client) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String req = br.readLine(); // 内容是："GET /web/index.html HTTP/1.1"
        String path = "day11-code" + req.split(" ")[1];
        System.out.println("请求的资源是：" + path);
        return path;
    }

}
