package Base_JAVA.base_21;

import java.io.*;

/*
    字符流底层其实也是字节流，但是还有数字与文字之间的翻译功能。参考表：ASCII、Unicode。

    字符流每次操作的至少一个一个的字符，字符与字节之间的对照关系，不一定的。
    如果是纯英文：一个字符就是一个字节。
    如果是其他字：一个字符有可能是1、2、3、4字节。
    如果是中国字：一个汉字有可能是2、3、4字节。
    具体由编码表来决定。

    如果希望直接操作字符，忽略字符与字节之间的翻译规则（编码），那么就可以使用字符流。

    字符输入流的最高抽象父类：java.io.Reader。其中定义了常用的抽象方法：
    public int read()：读取单个字符，返回对应的数字
    public int read(char[] buf)：读取字符数组，返回有效个数
    public void close()：关闭流

    常用子类是：java.io.FileReader
    构造方法：
    public FileReader(String filename)：参数就是需要读取的文件路径
    public FileReader(File file)：参数就是需要读取的文件对象

    使用步骤：创、读、关

    备注：字符流只能操作纯文本文件，凡是能用Windows默认记事本打开的。
 */
public class demo_FileReadAndWrite {

    public static void demo_FileReader() throws IOException {
        Reader reader = new FileReader("hello_code\\src\\1.txt");

        char[] buf = new char[1024];
        int len; // 代表有效个数
        while ((len = reader.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        reader.close();
    }

    public static void demo_FileWriter() throws IOException{
        /*
            字符输出流最高抽象父类：java.io.Writer。其中定义了常用的方法：
            public void write(int ch)：写单个字符
            public void write(char[] buf)：写全部字符数组
            public void write(char[] buf, int offset, int length)：写字符数组的一部分
            public void write(String str)：写全部字符串
            public void write(String str, int offset, int length)：写字符串的一部分
            public void close()：关闭

            常用子类是写文件的：FileWriter
            构造方法：
            public FileWriter(String filename)
            public FileWriter(String filename, boolean append)
            public FileWriter(File file)
            public FileWriter(File file, boolean append)

            使用步骤：创、写、(刷新)、关。

            上述输出流有一个flush方法，代表刷新动作。
            public void flush()：刷新缓冲区，立刻将其中的内容交给操作系统。

            我们通常读写数据分成两种情况：
            写数据到文件：write --> JVM当中的缓冲区 --> 满了自动交给OS --> 硬盘
            从文件读数据：read <-- JVM当中的缓冲区 <-- 空了自动找OS要 <-- 硬盘

            flush方法：将缓冲区当中的内容，立刻刷新交给操作系统。不会关闭流，后面还能继续用。
            close方法：包含了一个flush动作，并且还会关闭流，后面不能再用。

            FileOutputStream里面没有缓冲区，所以flush一点用处都没有。
            FileInputStream/FileReader/FileWriter里面都有byte[8192]字节数组作为缓冲区。
            后三者当中：
            读数据：一次性读进来8192字节的数据，每次read方法只是取出使用而已，用完了，继续再读最多8192字节数据。
            写数据：每次write方法只是向8192缓冲区当中写字节数据而已，如果满了，将会自动刷新交给操作系统。
        */
        Writer writer = new FileWriter("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\file04.txt");

        writer.write("Hello你好");

        writer.write("World", 1, 3); // orl

        writer.write(65); // A
        writer.write('B'); // char --> int --> 66

        //writer.flush();

        writer.close();
    }

    public static void main(String[] args) throws IOException {
        demo_FileReader();
        //demo_FileWriter();
    }
}
