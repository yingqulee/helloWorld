package Base_JAVA.base_22;


import java.io.*;

/*
    字符集：文字符号与字节数字之间的对照关系表。例如ASCII、Unicode。
    编码：用几个字节以什么规则来表示一个字符集当中的数字，这种规则叫做编码。

    Windows默认编码是：GBK
    Linux/macOS以及全世界的开发环境当中默认全都是：UTF-8
    对于常用的中文，GBK使用2个字节表示，但是UTF-8使用3个字节表示。

    乱码：写数据到文件当中用GBK，但是读取出来的时候用UTF-8，前后不一致，就会导致乱码。

    文件当中的内容是GBK编码，但是默认程序通过UTF-8读取，就会乱码。
    如果希望读取文件的时候，使用我们指定的编码，那么就需要使用转换流。
    转换流就是字节和字符之间来回翻译的桥梁，可以通过参数指定使用什么编码。

    输入转换流：InputStreamReader
    构造方法：
    public InputStreamReader(InputStream in)：使用系统默认编码。
    public InputStreamReader(InputStream in, String encoding)：第二个参数代表使用什么编码。

    InputStreamReader其实就是字符流Reader的子类，创建的时候指定编码，但是使用起来非常简单。
*/
public class demo_ChangeStream {

    public static void demo_InputStream() throws IOException {
        //构造方法中的指定的编码表名称要和文件的编码相同,否则会发生乱码
        InputStreamReader in = new InputStreamReader(new FileInputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file03-gbk.txt"), "GBK");

        /*int len;
        while ((len = in.read()) != -1) {
            System.out.println((char) len);
        }*/
        char[] chars = new char[1024];
        int len;
        while((len = in.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
        }

        in.close();
    }

    public static void demo_OutputStream() throws IOException {
        /*
            转换输出流：OutputStreamWriter
            构造方法：
            public OutputStreamWriter(OutputStream out)：使用系统默认编码
            public OutputStreamWriter(OutputStream out, String encoding)：第二个参数指定使用的编码

            这其实就是Writer的子类，使用起来基本一样。不一样就在于第二个构造参数可以指定编码。
        */
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file04.txt")); // UTF-8
        out.write("中国");
        out.close();

        OutputStreamWriter out2 = new OutputStreamWriter(new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file05.txt"), "GBK");
        out2.write("中国");
        out2.close();
    }

    public static void demo_Test() throws IOException {
        /*
            现在有一个文件，是GBK编码的。希望转换成为另一个文件，使用UTF-8编码。

            1. 用GBK编码读取源文件，InputStreamReader
            2. 用UTF-8编码写目标文件：OutputStreamWriter
            3. 循环
            4. 关闭流
        */
        InputStreamReader in = new InputStreamReader(new FileInputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file06-gbk.txt"),"GBK");

        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file06-utf8.txt"),"UTF-8");

        char[] chars = new char[1024];
        int len;
        while((len = in.read(chars)) != -1){
            out.write(chars,0,len);
        }

        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        //demo_InputStream();
        //demo_OutputStream();
        //demo_Test();
    }
}
