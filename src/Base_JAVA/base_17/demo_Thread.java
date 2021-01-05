package Base_JAVA.base_17;

/*
    进程：是操作系统当中正在运行的应用程序。例如运行一个QQ，再运行一个迅雷。
    线程：是应用程序内部的多个任务执行单位。例如迅雷当中“同时”下载的多个文件。

    线程是进程的内部执行任务的单位。

    JVM当中：栈内存是线程独立的，堆内存是线程共享的。
    Java程序当中至少有两个线程： 1. 主线程（main方法）2. 垃圾回收线程（gc线程）
    Java的多线程采用的是抢占式调度：
        很多个线程彼此互相抢CPU来执行，谁抢到了谁执行，没抢到等着下次再抢。
        无法控制多个线程互相之间详细的执行顺序。

    如何实现多线程程序：java.lang.Thread类即可。
    Thread类代表线程，一个Thread类对象，就是一个线程对象。

    使用步骤：
    1. 自定义一个类，来继承Thread类。
    2. Thread类当中有一个run方法，代表线程的任务内容。
    需要覆盖重写run方法，将具体做的操作放在run方法的方法体当中。
    3. 创建对象，并且启动线程：调用start()方法。

    注意：不要自己去调用run方法，否则没有任何多线程并发的效果。

    通过下面的方法可以获取当前线程的名称：
    String name = Thread.currentThread().getName();

    观察得到：
    1. 创建了三个线程对象，分别叫做Thread-0 Thread-1 Thread-2
    2. 三个线程对象，谁先谁后不一定的。
    3. 每个线程都要循环100次，有可能产生互相穿插的情况。（CPU正在进行来回切换）
 */
public class demo_Thread {

    public static void demo_Sleep() {
        for (int i = 1; i <= 60; i++) {
            System.out.println(i);

            //使用Thread类的sleep静态方法让程序睡眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void demo_Thread(){
        MyThread one = new MyThread();
        MyThread two = new MyThread();
        MyThread three = new MyThread();

        one.start();//调用start()方法.开辟新的栈内存
        two.start();
        three.start();
    }

    public static void demo_Runnable(){
        /*
            Thread还有两个构造方法比较常用：

            public Thread(Runnable target)：创建一个线程，参数代表线程的任务内容。
            public Thread(Runnable target, String name)：创建一个线程，第一个参数是任务内容，第二个参数是线程的名称。

            Runnable接口的使用步骤：
                1. 定义一个实现类，实现Runnable接口。
                2. 实现类必须覆盖重写run方法。
                3. 创建一个Runnable实现类对象，作为Thread的构造参数。
                4. 调用Thread对象的start方法启动线程。

            启动线程的两种方式，效果一样：
                1. 继承Thread类
                2. 实现Runnable接口

            实现Runnable接口比继承Thread类所具有的优势：
                1. 适合多个相同的程序代码的线程去共享同一个资源。
                2. 可以避免java中的单继承的局限性。
                3. 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
                4. 线程池只能放入实现Runable或Callable类线程，不能直接放入继承Thread的类。
            扩充：
                在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。
                因为每当使用java命令执行一个类的时候，实际上都会启动一个JVM，每一个JVM其实在就是在操作系统中启动了一个进程。
         */
        Runnable task = new MyRunnableImpl();

        new Thread(task).start();
        new Thread(task, "我的线程").start();
    }

    public static void demo_InnerClassThread(){
        //创建匿名内部类实现线程的创建
        //1.线程的父类是Thread
        new Thread(){
            //重写run()
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"-->"+"吴彦祖");
                }
            }
        }.start();

        //2.线程的接口是Runnable
        Runnable r = new Runnable(){
            //重写run()
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"-->"+"彭于晏");
                }
            }
        };
        new Thread(r).start();

        //3.简化接口的方式
        new Thread(new Runnable() {
            //重写run()
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"-->"+"金城武");
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        //demo_Thread();
        //demo_Sleep();
        //demo_Runnable();
        //demo_InnerClassThread();
    }
}
