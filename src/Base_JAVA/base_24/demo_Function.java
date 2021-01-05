package Base_JAVA.base_24;

import java.util.function.Function;

/*
    java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，
    后者称为后置条件。有进有出，所以称为“函数Function”。

    Function 接口中最主要的抽象方法为： R apply(T t) ，根据类型T的参数获取类型R的结果。使用的场景例如：
    将 String 类型转换为 Integer 类型。
 */
public class demo_Function {

    private static void method1(String s,Function<String, Integer> function) {
        int num = function.apply(s);
        System.out.println(num + 20);
    }

    //Function 接口中有一个默认的 andThen 方法，用来进行组合操作。和 Consumer 中的 andThen 差不多
    private static void method2(String str,Function<String, Integer> one, Function<Integer, String> two) {
        String s = one.andThen(two).apply(str);
        System.out.println(s);
    }

    /*
        请使用 Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
        1. 将字符串截取数字年龄部分，得到字符串；
        2. 将上一步的字符串转换成为int类型的数字；
        3. 将上一步的int数字累加100，得到结果int数字。
     */
    private static int getAgeNum(String str, Function<String, String> one, Function<String, Integer> two, Function<Integer, Integer> three) {
        return one.andThen(two).andThen(three).apply(str);
    }


    public static void main(String[] args) {
        /*String s = "10";
        method1(s,str -> Integer.parseInt(str));
        method2(s,str->Integer.parseInt(str)+10, i-> i+"");*/

        System.out.println("====================================");

        String str = "赵丽颖,20";
        int age = getAgeNum(str, s -> s.split(",")[1], s -> Integer.parseInt(s), n -> n += 100);
        System.out.println(age);
    }
}
