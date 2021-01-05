package Base_JAVA.base_24;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class demo_PracticeInterface {

    /*
        常用的函数式接口:
        java.util.function.Supplier<T>接口仅包含一个无参的方法： T get() 。用来获取一个泛型参数指定类型的对象数据

        Supplier<T>接口被称为生产型接口,指定接口的泛型是什么,那么接口的get方法就会生产什么类型的数据
     */
    private static String getString(Supplier<String> function) {
        return function.get();
    }

    /*
        练习:求数组元素的最大值
        使用Supplier接口作为方法参数类型,通过lambda表达式求出int数组中的最大值
        接口的泛型请使用Integer类
     */
    private static int getMax(Supplier<Integer> function){
        return function.get();
    }

    /*
        java.util.function.Consumer<T> 接口则正好相反，
        它不是生产一个数据，而是消费一个数据，其数据类型由泛型参数决定。

        Consumer 接口中包含抽象方法 void accept(T t) ，意为消费一个指定泛型的数据。
     */
    private static void consumeString(Consumer<String> function) {
        function.accept("Hello");
    }

    private static void consumeString(Consumer<String> one, Consumer<String> two) {
        /*one.accept("hello");
        two.accept("hello");*/
        one.andThen(two).accept("Hello");
    }

    /*
        java.util.function.Predicate<T> 接口:对某种数据类型的数据进行判断,结果返回一个boolean值

        boolean test(T t):用来对指定的数据类型数据进行判断的方法
     */
    private static boolean checkString(String s, Predicate<String> function){
        return function.test(s);
    }

    public static void main(String[] args) {

        /*String msgA = "Hello";
        String msgB = "World";
        System.out.println(getString(()-> msgA + msgB));*/
//===============================================================
        /*int[] array = { 10, 20, 100, 30, 40, 50 };
        int maxValue = getMax(()->{
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        });
        System.out.println("最大值是: "+ maxValue);*/
//===============================================================
        /*consumeString(s -> {
            String re = new StringBuffer(s).reverse().toString();
            System.out.println(re);
        });

        consumeString(System.out::println);*/
//===============================================================
        /*consumeString(
                s -> System.out.println(s.toUpperCase()),
                s -> System.out.println(s.toLowerCase()));*/
//===============================================================
        String s = "abcdef";

        System.out.println(checkString(s,str->str.length()>5));
    }
}
