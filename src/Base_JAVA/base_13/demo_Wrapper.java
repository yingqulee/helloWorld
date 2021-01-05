package Base_JAVA.base_13;

public class demo_Wrapper {

    public static void demo_01_Wrapper(){
        /*
        基础班学习集合的时候，由于泛型不能是基本类型，所以我们用包装类进行了替代。

        基本类型    包装类（全都位于java.lang包下）
        byte        Byte
        short       Short
        int         Integer
        long        Long
        float       Float
        double      Double
        char        Character
        boolean     Boolean

        包装类的作用并不仅仅是替代int等基本类型，功能比较丰富。
        将基本类型包装起来，套一个对象的壳子，这样功能就会更加丰富。

        自动装箱、自动拆箱。
         */
        System.out.println(Integer.MAX_VALUE); // 最大值
        System.out.println(Integer.MIN_VALUE); // 最小值
    }

    public static void demo_02_WrapperBoxing(){
        /*
        从JDK 1.5+开始，Java当中添加了小特性：

        自动装箱：把基本类型转换成为对应的包装类对象      int --> Integer         Integer.valueOf方法
        自动拆箱：把包装类对象转换成为对应的基本类型      Integer --> int         包装类对象.intValue方法

        “自动”说的是这种来回转换，无需人工干预，自动完成。

        语法糖：底层原理其实没变，只不过是代码写法变得简单一些。
         */
        Integer obj = 100; // int --> Integer，自动装箱
        Integer obj2 = Integer.valueOf(200); // 底层原理
        //Integer obj3 = new Integer(300); // 不推荐

        // 拆箱
        int num = obj; // Integer --> int
        int num2 = obj.intValue(); // 底层原理
        System.out.println(obj2+" "+obj+" "+num+" "+num2);
    }

    public static void demo_03_WrapperConvert(){
        /*
        将基本数据类型转换成为字符串：
            1. "" + 基本数据值
            2. String.valueOf静态方法
            3. 先把基本类型变成对应的包装类，然后调用包装类的toString方法。（不推荐）
            将字符串转换成为基本数据类型：
            包装类的转换方法：
            public static XXX parseXXX(String str)：将参数字符串，转换成为对应基本类型的数据值。
         */
        //基本类型-->字符串(String)
        String str1 = "" + 100;
        System.out.println(str1+200);//100200

        String str2 = Integer.toString(100);
        System.out.println(str2+200);//100200
        //注意:
        System.out.println("hello" + 10 + 20);//hello1020
        System.out.println(10 + 20 + "hello");//30hello

        String str3 = String.valueOf(100);
        System.out.println(str3+200); // 100200

        //字符串(String)-->基本类型
        String str4 = "100";
        int num = Integer.parseInt(str4);
        num += 10;
        System.out.println(num); // 110
    }

    public static void main(String[] args) {
        //demo_01_Wrapper();
        //demo_02_WrapperBoxing();
        //demo_03_WrapperConvert();
    }
}
