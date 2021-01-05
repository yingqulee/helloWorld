package Base_JAVA.base_21;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//如果直接无脑throws，那么后果就是但凡出现任何异常，程序整体崩溃。
public class demo_Exception {

    public static void demo_01(){
        /*
            在JDK1.7之前使用try catch finally处理流中的异常
        */

        //提高变量的作用域
        FileWriter fw = null;
        FileReader fr = null;
        try {
            fw = new FileWriter("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\file08.txt");
            fw.write("Hello");
            fr = new FileReader("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\file09.txt");
            System.out.println(fr.read());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //一定会执行的代码
            try {
                //如果创建对象失败了,默认值就是null,会抛出空指针异常,需要加判断
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void demo_02(){
        /*
            从Java 7开始，加入了一种新的格式，名叫try-with-resource。
            可以将IO流自动关闭，并且和异常处理结合到一起，方便使用。不用在写finally了

            try (声明资源) {
                使用资源
            } catch (异常) {
                处理异常
            }

            1. 在小括号当中声明的资源，将会自动关闭。
            2. 只有AutoCloseable接口的实现类对象，才能这么用。
         */
        try (FileWriter fw = new FileWriter("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\file01.txt");
             FileReader fr = new FileReader("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\file02.txt")) {

            fw.write("Hello");
            System.out.println(fr.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        demo_01();
    }
}
