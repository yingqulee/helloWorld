package Base_JAVA.base_17;

/*
    使用步骤：
    1. 自定义一个类，来继承Thread类。
    2. Thread类当中有一个run方法，代表线程的任务内容。
    需要覆盖重写run方法，将具体做的操作放在run方法的方法体当中。
    3. 创建对象，并且启动线程：调用start()方法。

    注意：不要自己去调用run方法，否则没有任何多线程并发的效果。
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        //需要覆盖重写run方法，将具体做的操作放在run方法的方法体当中。
        String name = Thread.currentThread().getName(); // 获取当前线程的名称
        for (int i = 1; i <= 100; i++) {
            System.out.println(name + " - " + i);
        }
    }
}
