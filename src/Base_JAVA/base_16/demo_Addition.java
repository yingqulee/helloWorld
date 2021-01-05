package Base_JAVA.base_16;


/*
    Java 9，添加了几种集合工厂方法,更方便创建少量元素的集合、map实例。新的List、Set、Map的静态工厂方法可以更方便地创建集合的不可变实例。

    static <E> List<E> of (E...elements)
    使用前提:
        当集合中存储的元素的个数已经确定了,不再改变时使用

    注意:
        1.of方法只使用与List接口,Set接口,Map接口,不适应于接口的实现类:HashSet,HashMap...
        2.of方法的返回值是一个不能改变的集合,集合不能在使用add,put方法添加元素,会出现异常
        3.Set接口和Map接口在调用of方法的时候,不能有重复的元素,否则会出现异常
 */
public class demo_Addition {

    public static void demo_debug(){
        /*
            debug调试程序:
                可以让代码逐行执行,查看代码执行的过程,调试程序中出现的bug
            使用方式:
                在行号的右边,鼠标左键单击,添加断点
                右键,选择debug执行
            执行程序:
                f8:逐行执行程序
                f7:进入到方法中
                shift + f8:跳出方法
                f9:跳到下一个断点,如果没有就结束程序
                ctrl + f2:退出debug模式
         */
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println(sum);
    }

    public static void main(String[] args) {
        demo_debug();
    }
}
