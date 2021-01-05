package Base_JAVA.base_22;


import java.io.*;
import java.util.ArrayList;

/*
    对象的序列化：将内存当中的对象数据，写到文件当中去。ObjectOutputStream
    构造方法：
    public ObjectOutputStream(OutputStream out)：参数字节流代表把数据写到哪里去
    写对象的方法：
    public void writeObject(Object obj)：参数代表需要写的对象是谁

    注意事项：
    1. 需要进行序列化的对象的类，必须实现java.io.Serializable接口。
    2. Serializable接口是一个空接口，标识接口。
    3. 需要进行序列化的类，其中所有的成员变量对应的类型，也必须实现Serializable接口。
    4. 如果有一些成员变量不希望参与序列化，排除某些成员变量，使用transient关键字修饰即可。
    例如：private transient int age;
*/
public class demo_Serialization {

    private static void demo_01() throws IOException {
        Person person = new Person("大西几", 6);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file07-obj.txt"));

        out.writeObject(person);

        out.close();
    }

    private static void demo_SerializationReverse() throws IOException, ClassNotFoundException {
        /*
            反序列化：将硬盘当中文件里存储的对象数据，读取到内存当中成为一个对应的对象。
            对应的类是：ObjectInputStream

            构造方法：
            public ObjectInputStream(InputStream in)：参数代表从哪里读取字节数据

            读对象的方法：
            public Object readObject()：读取文件当中的数据，成为一个对象。
        */
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file07-obj.txt"));

        Object obj = in.readObject();
        System.out.println(obj);

        //转换类型
        if (obj instanceof Person) {
            Person person = (Person) obj;
            System.out.println(person.getName()+" "+person.getAge()); // 大西几
        }

        in.close();
    }

    private static  void demo_Test() throws IOException, ClassNotFoundException {
        ArrayList<Person> list1 = new ArrayList<>();

        list1.add(new Person("理迎趣",18));
        list1.add(new Person("吴彦祖",27));
        list1.add(new Person("彭于晏",29));
        list1.add(new Person("金城武",28));

        ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\myLYQ.txt"));
        objout.writeObject(list1);

        ObjectInputStream objin = new ObjectInputStream(new FileInputStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\myLYQ.txt"));
        Object o = objin.readObject();

        //转换为ArrayList类型
        ArrayList<Person> list2 = (ArrayList<Person>) o;

        for (Person person : list2) {
            System.out.println(person.getName()+"==="+person.getAge());
        }

        objin.close();
        objout.close();
    }

    private static void demo_PrintStream() throws FileNotFoundException {
        /*
            System.out代表标准输出流
            System.err代表错误输出流
            System.in代表标准输入流

            打印流名叫PrintStream。这个流的特点就是：直接调用println或者print方法，使用方便。

            构造方法：
            public PrintStream(String filename)：参数就是对应的文件名称。

            默认情况下，输出语句会将数据显示在下方控制台，也叫做cmd。
            可以通过一个方法来改变默认System.out.println方法的导向：
            System.setOut(PrintStream ps)
        */
        System.out.println("我在控制台输出这句话");

        PrintStream ps = new PrintStream("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\file09.txt");

        System.setOut(ps);//把输出语句的目的地改变为打印流的目的地
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("我怎么在文件当中了?");

        ps.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //demo_01();
        //demo_SerializationReverse();
        //demo_Test();
        //demo_PrintStream();
    }
}
