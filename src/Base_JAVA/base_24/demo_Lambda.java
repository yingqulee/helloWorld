package Base_JAVA.base_24;

import java.util.Arrays;
import java.util.Comparator;
/*
    双冒号 :: 为引用运算符，而它所在的表达式被称为方法引用。如果Lambda要表达的函数方案已经存在于某个方
    法的实现中，那么则可以通过双冒号来引用该方法作为Lambda的替代者。
 */
public class demo_Lambda {
    //方法使用该接口作为参数，那么就可以使用Lambda进行传参。
    //这种情况其实和 Thread 类的构造方法参数为 Runnable 没有本质区别。
    private static void startThread(Runnable run){
        new Thread(run).start();
    }

    //方法的返回值类型是一个函数式接口，那么就可以直接返回一个Lambda表达式。
    private static Comparator<String> newComparator() {
        return (a,b)->b.length()-a.length();
    }

    public static void main(String[] args) {
        //startThread(()->System.out.println(Thread.currentThread().getName()+"线程任务执行！"));


        String[] array = { "abc", "ab", "abcd" };
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, newComparator());
        System.out.println(Arrays.toString(array));
    }
}
