package Base_JAVA.base_24;

/*
    性能浪费的日志案例
 */
public class demo_Logger {

    /*
        无论级别是否满足要求，作为 log 方法的第二个参数，三个字符串一定会首先被拼接并传入方
        法内，然后才会进行级别判断。如果级别不符合要求，那么字符串的拼接操作就白做了，存在性能浪费
     */
    private static void demo_log(int level, String msg) {
        if (level == 1) {
            System.out.println(msg);
        }
    }

    /*
        使用lambda优化日志案例
        lambda的特点:延迟加载
        lambda的使用前提,必须存在函数式接口

        使用lambda表达式作为参数传递,仅仅是把参数传递到方法中
        只有满足条件才会调用方法,才进行字符串拼接
        所有不会存在性能的浪费
     */
    private static void demo_lambdaLog(int level, Logger builder) {
        if (level == 1) {
            System.out.println(builder.buildMessage());
        }
    }

    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";
        demo_log(1, msg1 + msg2 + msg3);

        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        demo_lambdaLog(2,()->msgA + msgB + msgC);
    }

}
