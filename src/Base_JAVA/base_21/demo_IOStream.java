package Base_JAVA.base_21;

import java.io.*;

public class demo_IOStream {

    public static void demo_OutputStream() throws IOException {
        /*
            字节输出流，最高抽象父类是：java.io.OutputStream。其中定义的常用方法：
            public void write(int b)：写一个字节数据。
            public void write(byte[] array)：写整个字节数组。
            public void write(byte[] array, int offset, int length)：写字节数组的一部分。
            public void close()：关闭流，释放系统资源。

            常用的子类是：FileOutputStream
            构造方法：
            public FileOutputStream(String filename)：参数就是文件路径名，字符串。
            public FileOutputStream(File file)：参数就是文件对象。

            使用FileOutputStream写文件的基本步骤：
            1. 创：创建FileOutputStream对象，指定文件路径。
            2. 写：调用write方法写字节byte数据。
            3. 关：调用close方法关闭流。

            备注：
            1. 如果需要写的文件不存在，那么在new的时候将会自动创建空文件。
            2. 如果需要写的文件已经存在，那么将会覆盖。
            3. flush方法对于OutputStream及其子类FileOutputStream来说，一点用处都没有。
            4. 指定文件路径的时候，使用绝对路径或者使用相对路径都是可以的。

            写入数据的原理(内存-->硬盘)
                java程序-->JVM-->OS-->OS调用写数据的方法-->把数据写入到文件中
        */
        // 1. 创建字节输出流对象，用来写文件，指定文件的路径名
        /*OutputStream out = new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\file01.txt");

        out.write("Hello".getBytes());

        // 2. 写，调用write方法,写数据的时候,会把十进制的整数转换为二进制整数
        out.write(97); // a

        byte[] array = {98, 99, 100}; // b, c, d
        out.write(array);

        // 从0号开始，取用数组当中的2个长度
        out.write(array, 0, 2);

        // 3. 关闭流
        out.close();*/

        /*
            如果使用刚才的构造方法，那么文件存在的时候，将会覆盖原有内容。
            如果希望不要覆盖，而是追加写入更多新内容，需要使用另外的构造方法：

            public FileOutputStream(String filename, boolean append)：第二个参数如果是true，就会追加写入。
            public FileOutputStream(File file, boolean append)：同上。

            换行:
            Windows当中的换行符是两个字符：\r\n
            Linux/macOS当中的换行符是一个字符：\n

            为了保证跨平台性，换行符可以调用：System.lineSeparator()
         */
        OutputStream out1 = new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\file01.txt", true);

        String sep = System.lineSeparator();
        String str = sep+"草草草草草草";

        out1.write(str.getBytes());
        out1.close();
    }

    public static void demo_InputStream() throws IOException {
        /*
            字节输入流的最高抽象父类是：java.io.InputStream，其中定义了常用的方法：
            public int read()：读取单个字节
            public int read(byte[] buf)：读取字节数组，返回有效个数。
            public void close()：关闭流，释放资源。

            常用的用来读文件的子类是：FileInputStream
            构造方法：
            public FileInputStream(String filename)：代表需要读取的文件路径，字符串
            public FileInputStream(File file)：代表需要读取的文件对象

            使用FileInputStream读文件的步骤：
            1. 创：创建FileInputStream对象，指定文件路径。
            2. 读：调用read方法读取字节数据
            3. 关：调用close方法关闭流，释放资源

            备注：
            1. 不会自动创建文件的，如果文件不存在，将会发生FileNotFoundException。
            2. 每次调用read()方法都会读取下一个字节数据。
        */
        InputStream in = new FileInputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\file03.txt");

        /*int b ;// 代表读取出来的单个字节
        while((b=in.read()) != -1){
            System.out.print((char)b);
        }*/

        //-----------------------------------------------------

        //public int read(byte[] buf)：读取字节数组，参数代表字节数组用来装内容，返回值代表数组当中的有效个数。
        byte[] bytes = new byte[1024];//一般为1024

        /*int b = in.read(bytes);
        System.out.println(b);*/

        int len;// 代表有效个数

        while ((len = in.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        in.close();
    }

    public static void demo_CopyFile() throws IOException {
        /*
            使用单个字节的方式复制文件。

            1. 创建字节输入流，读取源文件。FileInputStream        C:\Rolling.mp3
            2. 创建字节输出流，写目标文件。FileOutputStream       D:\Rolling.mp3
            3. 从输入流读取一个字节：read()
            4. 将这个字节写到输出流：write(int)
            5. 上述3-4步骤是一个循环
            6. 关闭两个流
         */
        long start = System.currentTimeMillis();

        // 创建一个字节输入流，读取C盘当中的文件
        InputStream in = new FileInputStream("C:\\Users\\15955\\Pictures\\Screenshots\\屏幕截图(42).png");
        // 创建一个字节输出流，写E盘当中的文件
        OutputStream out = new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\屏幕截图(42).png");

        /*int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }*/
        //使用数组缓冲优化
        byte[] bytes = new byte[1024];
        int len;//每次读取的有效字节个数

        while((len = in.read(bytes))!= -1){
            out.write(bytes,0,len);
        }

        //释放资源(先关写的,后关读的;如果写完了,肯定就是读完了)
        out.close();
        in.close();

        long end = System.currentTimeMillis();
        System.out.println("复制文件一共耗时: "+(end - start)+"毫秒");
    }

    public static void main(String[] args) throws IOException {
        //demo_OutputStream();
        //demo_InputStream();
        //demo_CopyFile();
    }
}
