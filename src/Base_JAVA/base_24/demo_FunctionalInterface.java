package Base_JAVA.base_24;


/*
    函数式接口的使用:一般可以作为方法的参数和返回值类型
 */
public class demo_FunctionalInterface {

    public static void show(FunctionalInterface fi){
        fi.method();
    }

    public static void main(String[] args) {
        //调用show方法,方法的参数是一个接口,所以可以传递接口的实现类对象
        show(new FunctionalInterfaceImpl());

        //调用show方法,方法的参数是一个接口,所以可以传递接口的匿名内部类
        show(new FunctionalInterface() {
            @Override
            public void method() {
                System.out.println("你好!我是匿名内部类");
            }
        });

        //调用show方法,方法的参数是一个函数式接口,所以我们可以用lambda表达式
        show(()->{
            System.out.println("你好!我是lambda表达式");
        });

        //简化lambda表达式
        show(()-> System.out.println("你好!我是优化过的lambda表达式"));
    }
}
