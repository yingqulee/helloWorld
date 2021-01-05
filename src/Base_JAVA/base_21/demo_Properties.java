package Base_JAVA.base_21;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
    Map
        |-- HashMap         底层哈希表，线程不安全，特别常用
        |-- Hashtable       底层哈希表，线程安全，性能不如HashMap快，不是很常用
            |-- Properties  底层也是哈希表，线程也是安全，性能也不咋地，但是特殊场景下使用非常方便。

    Properties其实就是一个Map，只是泛型固定成为<Object, Object>。

    特有的常用方法：
    public Object setProperty(String key, String value)：类似于put方法，只是参数写成了String
    public String getProperty(String key)：类似于get方法，只是参数和返回值都写成了String
    public Set<String> stringPropertyNames()：类似于keySet，只是得到的全都是字符串集合。

    上述三个方法和Map<String, String>几乎没什么太大区别
    public String put(String key, String value)
    public String get(Object key)
    public Set<String> entrySet()
 */
public class demo_Properties {

    public static void demo_01(){
        Properties properties = new Properties();

        properties.setProperty("吴彦祖","188");
        properties.setProperty("彭于晏","156");

        System.out.println("吴彦祖身高多少? " + properties.getProperty("吴彦祖"));//根据键查找值

        Set<String> names = properties.stringPropertyNames();
        for (String key : names) {
            String value = properties.getProperty(key);
            System.out.println(key+"="+value);
        }
    }

    public static void demo_02() throws IOException {
        /*
            可以使用Properties集合中的方法store,把集合中的临时数据,持久化写入到硬盘当中
            void store(OutputStore out, String comments) 字节输出流,不能写入中文
            void store(Writer writer, String comments) 字符输出流,可以写入中文

            String comments:注释,不能使用中文,会乱码
         */
        //1.创建properties集合对象,添加数据
        Properties properties = new Properties();
        properties.setProperty("理迎趣","180");
        properties.setProperty("吴彦祖","170");
        properties.setProperty("彭于晏","172");

        //2.创建字符输出流对象,构造方法中绑定要输出的目的地
        Writer out = new FileWriter("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\property1.txt");

        //3.使用properties结合中的方法store,把集合中的临时数据,持久化到硬盘中储存
        properties.store(out,"save something");

        //4.释放资源
        out.close();
    }

    public static void demo_03_PropertiesLoad() throws IOException {
        /*
            public void load(InputStream inStream) ： 从字节输入流中读取键值对。
            public void load(Reader reader)
                参数:
                    InputStream inStream:字节输入流,不能读取含有中文的键值对
                    Reader reader:字符流输入流,能读取含有中文的键值对
         */
        //1.创建Properties集合对象
        Properties properties = new Properties();
        //2.使用Properties集合对象中的方法load读取保存键值对的文件
        properties.load(new FileReader("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day09-code\\property1.txt"));
        //3.遍历Properties集合
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            String value = properties.getProperty(key);
            System.out.println(key+" = "+value);
        }
    }

    public static void main(String[] args) throws IOException {
        //demo_01();
        //demo_02();
        //demo_03_PropertiesLoad();
    }
}
