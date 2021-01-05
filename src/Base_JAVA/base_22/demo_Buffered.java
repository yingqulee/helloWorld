package Base_JAVA.base_22;

import java.io.*;

public class demo_Buffered {

    public static void demo_bufferedStream() throws IOException {
        /*
            四个最高抽象父类：InputStream、OutputStream、Reader、Writer
            常用的四个子类：FileInputStream、FileOutputStream、FileReader、FileWriter
            四个缓冲的流：BufferedInputStream、BufferedOutputStream、BufferedReader、BufferedWriter

            IO流当中的缓冲流也叫做高效流，底层内置好了一个缓冲数组，从而提高数据读写的效率。

            字节缓冲输入流：BufferedInputStream
            字节缓冲输出流：BufferedOutputStream
            构造方法：
                public BufferedInputStream(InputStream in)：将参数普通的字节输入流，包装成为缓冲的字节输入流。
                public BufferedOutputStream(OutputStream out)：将参数普通的字节输出流，包装成为缓冲的字节输出流。

            复制文件的步骤：
            1. 创建一个字节输入流读取源文件：FileInputStream
            2. 将这个普通的字节输入流，包装成为缓冲的字节输入流：new BufferedInputStream(普通的字节输入流)
            3. 创建一个字节输出流写目标文件：FileOutputStream
            4. 将这个普通的字节输出流，包装成为缓冲的字节输出流：new BufferedOutputStream(普通的字节输出流)
            5. 通过单个字节或者字节数组的方式，倒手，循环，读写。
            6. 关闭流。
         */
        //字节缓冲输出流
        /*FileOutputStream out = new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\out.txt");
        BufferedOutputStream bfout = new BufferedOutputStream(out);
        bfout.write("写入缓冲区中,abcde".getBytes());
        bfout.flush();//不刷新的话数据还不会更新到txt中
        bfout.close();*/

        //字节缓冲输入流
        FileInputStream in = new FileInputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\out.txt");
        BufferedInputStream bfin = new BufferedInputStream(in);

        //一次一个
        /*int len;
        while((len=in.read())!=-1){
            System.out.println(len);
        }*/
        //一次一堆
        byte[] bytes = new byte[1024];
        int len;//有效个数
        while((len=in.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        bfin.close();
    }

    public static void demo_CopyFile() throws IOException {
        long start = System.currentTimeMillis();

        // 创建一个普通的字节输入流
        InputStream in = new FileInputStream("C:\\Users\\15955\\Pictures\\Screenshots\\屏幕截图(42).png");
        // 将这个普通的字节输入流，包装成为缓冲的~
        BufferedInputStream buffIn = new BufferedInputStream(in);

        // 创建一个普通的字节输出流
        // 将这个普通的字节输出流，包装成为缓冲的~
        BufferedOutputStream buffOut = new BufferedOutputStream(
                new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\屏幕截图(42).png"));

//        int b; // 单个字节
//        while ((b = buffIn.read()) != -1) {
//            buffOut.write(b);
//        }

        // 从输入流的缓冲数组当中，最多取出1023个字节，放到输出流的缓冲数组当中
        byte[] buf = new byte[1024];
        int len; // 有效个数
        while ((len = buffIn.read(buf)) != -1) {
            buffOut.write(buf, 0, len);
        }

        buffIn.close();
        buffOut.close();

        System.out.println(System.currentTimeMillis() - start);
    }

    public static void demo_bufferedWriter() throws IOException {
        /*
            缓冲的字符输出流：BufferedWriter
            构造方法：
            public BufferedWriter(Writer writer)：将参数普通的字符输出流，包装成为缓冲的字符输出流。

            只有创建的时候，有一点区别；真正使用起来，和FileWriter基本一样。

            TIP:
            FileWriter底层有一个缓冲数组byte[8192]
            BufferedWriter底层有一个缓冲数组char[8192]

            BufferedWriter还额外提供一个换行的方法：
            public void newLine()：写入换行符，自动根据操作系统选择合适的\r\n或者是\n

            Windows换行符：\r\n
            Linux/macOS换行符：\n
            System.lineSeparator()
        */
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file01.txt"));

        bw.write("Hello, World!");
        bw.newLine();
        bw.write("I Love Java Teacher!");

        bw.close();
    }

    public static void demo_bufferedRead() throws IOException {
        /*
            缓冲的字符输入流：BufferedReader
            构造方法：
            public BufferedReader(Reader reader)：将参数普通的字符输入流，包装成为缓冲的字符输入流。

            只有创建的时候有一点区别，使用起来和普通的FileReader基本一样。

            TIP：
            FileReader底层有一个缓冲数组：byte[8192]
            BufferedReader底层的缓冲数组：char[8192]

            BufferedReader额外提供的方法有：
            public String readLine()：读取一整行字符串，返回字符串的内容（不包含换行符）
        */
        BufferedReader br = new BufferedReader(new FileReader("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file02.txt"));

//        int ch; // 单个字符
//        while ((ch = br.read()) != -1) {
//            System.out.println((char) ch);
//        }

//        char[] buf = new char[2];
//        int len;
//        while ((len = br.read(buf)) != -1) {
//            System.out.println(new String(buf, 0, len));
//        }

//        String str;
//        str = br.readLine();
//        System.out.println(str);
//
//        str = br.readLine();
//        System.out.println(str);
//
//        str = br.readLine();
//        System.out.println(str); // null

        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        br.close();

    }

    public static void main(String[] args) throws IOException {
        //demo_bufferedStream();
        //demo_CopyFile();
        //demo_bufferedWriter();
        //demo_bufferedRead();
    }
}
