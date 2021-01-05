package Base_JAVA.base_13;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class demo_Object {

    public static void demo_01_Object(){
        /*
        java.lang.Object类是所有类的最高父类，所以其中有什么方法，所有子类全都可以有所有。

        备注：直接通过println方法打印对象，得到的是一个“地址哈希值”。

        Object当中定义了一个toString方法：
        public String toString()：没有参数，将当前对象转换成为字符串形式。

        例如看房子：
        地址：北京市海淀区海淀南路1024号
        内容：朝向好不好、几室几厅、面积多少……

        如果没有覆盖重写toString，将会使用Object当中继承下来的方法，默认做法就是：类型+@+16进制地址值
        如果不想要地址值，而是希望看一看对象的内容，那么就需要覆盖重写。

        注意：如果直接打印对象名称，那么println方法也会自动调用参数对象的toString方法。

        小结：
        1. 所有对象都能继承一个toString方法，用来将自己转换成为字符串。
        2. 如果没有覆盖重写，那么Object默认的toString就是拼接地址值。
        3. 如果希望体现成员变量内容，那么Alt + Insert生成toString方法即可。
        4. 覆盖重写以后，创建子类对象，优先用子类覆盖重写的toString方法。

        注意事项，特别强调：【这不是Arrays.toString方法！！！】
        java.lang.Object当中的方法：  public String toString()
        用法：对象名.toString()

        java.util.Arrays当中的方法：  public static String toString(数组)
        用法：Arrays.toString(数组)
         */
        //Object的toString()方法;
        Person one = new Person("赵丽颖", 18);
        System.out.println(one); // Person{name='赵丽颖', age=18}

        String str = one.toString(); // 来源于父类Object当中的。
        System.out.println(str); // Person{name='赵丽颖', age=18}

        //看一个类是否重写了toString()方法,直接打印这个类的对象即可,如果没有重写toString方法那么打印的是对象的地址值
        Random random = new Random();
        System.out.println(random);//java.util.Random@4554617c 没有重写

        Scanner in = new Scanner(System.in);
        System.out.println(in);//重写了

    }

    public static void demo_02_Equals(){
        /*
        曾经学习java.lang.String类的时候，就见到过这个方法：
        public boolean equals(Object obj)：比较当前对象和参数对象，返回是否一样。
        String当中并不是原创，这个方法其实来自于java.lang.Object最高父类，所以所有对象其实都有这个equals方法。

        关于==运算符的含义：
        1. 对于基本类型来说，==是进行数据值比较。
        2. 对于引用类型来说，==是进行【地址值】比较。

        Object当中的equals方法默认就是地址值比较，
        如果希望进行真正的对象内容比较，那么子类就必须覆盖重写equals方法和hashCode方法。

        注意事项：
        必须同时覆盖重写hashCode和equals方法，缺一不可！
        hashCode方法的作用，会在day03的时候，结合集合的知识重点强调。
         */
        Person one = new Person("鹿晗", 20);
        Person two = new Person("鹿晗", 20);
        Person three = new Person("马晗", 25);

        System.out.println(one == two); // false，地址值比较
        System.out.println(two == three); // false，地址值比较
        System.out.println("==============");

        //如果没有同时覆盖重写hashCode和equals方法,返回值是false
        System.out.println(one.equals(two)); // true, 没有重写就是false
        System.out.println(two.equals(three)); // false
    }

    public static void demo_03_Objects(){
        /*
        从JDK 1.7+开始，加入了一个工具类：java.util.Objects类---容忍空指针
        其中有一个非常好用的方法：
        public static boolean equals(Object a, Object b)：比较两个参数对象是否一样。

        复习一下，equals方法具有对称性。
        a.equals(b)和b.equals(a)效果应该一样。
        使用建议：
        如果是一个常量和一个变量进行equals比较，尽量把常量写在前边。

        使用建议：
        如果希望进行两个对象的内容比较，非常推荐使用Objects.equals方法，
        这个方法可以极大避免null的检查。
         */
        String str1 = null;

        System.out.println("Hellolo".equals(str1)); // false
//        System.out.println(str1.equals("Hellolo")); // NullPointerException 空指针异常
        System.out.println("==========");


        String str2 = null;
        String str3 = null;
        boolean same = Objects.equals(str2, str3);//可以防止空指针异常
        System.out.println(same);
    }

    public static void main(String[] args) {
        //demo_01_Object();
        //demo_02_Equals();
        //demo_03_Objects();
    }

}
