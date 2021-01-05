package Base_JAVA.base_13;

public class demo_StringBuilder {

    public static void demo_01_StringBuilder(){
        /*
        java.lang.StringBuilder构造方法：

        public StringBuilder()：无参，内容空白
        public StringBuilder(String str)：有字符串参数，直接将参数放在底层数组当中。

        字符串缓冲区,可以提高字符串的操作效率(看成一个长度可以变化的字符串)
        StringBuilder在内存中始终是[一个]数组,占用空间少,效率高
        如果超出了StringBuilder的容量,会自动扩容(一般是 byte[] value = new byte[16])

        备注：StringBuilder直接打印不是地址值，而是内容。
        因为：StringBuilder覆盖重写了Object继承下来的toString方法。
        */
        StringBuilder sb1 = new StringBuilder(); // 留空，内容就是空白""
        System.out.println(sb1); // 空白

        StringBuilder sb2 = new StringBuilder("Hello"); // 创建的同时，立刻放入字符串，作为初始值
        System.out.println(sb2); // Hello
    }

    public static void demo_02_StringBuilderAppend(){
        /*
        StringBuilder当中，如果希望拼接追加更多内容，可以使用方法：
        public StringBuilder append(任意类型)：继续追加内容到底层数组中，如果不够，自动扩容。

        append方法当中最后一行就是return this。返回值和调用方法之前的对象自己，根本就是同一个。
        好处：这样可以支持链式调用，一环扣一环。
         */
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Java");
        sb1.append("Money");
        sb1.append("China");
        System.out.println(sb1); // JavaMoneyChina

        sb1.append(97);
        sb1.append(true);
        sb1.append(3.5);
        System.out.println(sb1); // JavaMoneyChina97true3.5

        System.out.println("==============");

        StringBuilder sb2 = new StringBuilder("Hello");
        StringBuilder sb3 = sb2.append("World");

        System.out.println(sb2); // HelloWorld
        System.out.println(sb3); // HelloWorld
        //把sb2的地址赋值给sb3 所以地址相同
        System.out.println(sb2 == sb3); // true 比较的是地址
        System.out.println("==============");

        StringBuilder sb4 = new StringBuilder();
        sb4.append("AAA").append("BBB");
        sb4.append("XXX").append("OOO");
        System.out.println(sb4); // AAABBBXXXOOO
    }

    public static void demo_03_StringBuildertoString(){
        /*
        字符串转换成为StringBuilder：
            1. 构造方法：public StringBuilder(String str)
            2. 成员方法：append
        StringBuilder转换成为字符串：
            直接调用toString方法即可，继承自Object类，我自己有覆盖重写。
         */
        String str = "hello";
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb); // hello

        System.out.println("=======");

        String str2 = "world";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        System.out.println(sb2); // world
        System.out.println("=======");

        sb2.append(100).append(3.5).append(true);
        String result = sb2.toString();
        System.out.println(result); // world1003.5true
    }

    public static void main(String[] args) {
        //demo_01_StringBuilder();
        //demo_02_StringBuilderAppend();
        //demo_03_StringBuildertoString();
    }
}
