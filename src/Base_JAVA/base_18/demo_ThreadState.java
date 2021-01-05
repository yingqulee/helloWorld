package Base_JAVA.base_18;

public class demo_ThreadState {

    private static final Object LOCK = new Object();

    public static void demo_WaitingAndNotify(){
        /*
        与WAITING状态相关的两个方法：

        public void wait()：当前线程主动释放锁，进入WAITING无限平静等待，死等。等待别人通知我，我再继续。
        public void notify()：通过锁调用，通知在这个锁上处于等待状态的人。

        这两个方法必须通过多个线程之间共享的锁对象进行调用，而且必须在同步代码范围之内调用。
        */
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK){
                    System.out.println("AAA即将释放锁，进入WAITING状态");
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("AAA收到了通知，正常结束");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    LOCK.notify();
                    System.out.println("BBB已经通知了对方");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("BBB结束");

                }
            }
        }).start();
    }

    public static void demo_TimeWaiting(){
        /*
        wait方法的重载形式：

        public void wait(long millis)：主动释放锁，进入TIMED_WAITING状态，但是最多等待参数毫秒时长。
        如果在此期间之内，有人通知我，那我就结束等待；
        如果超过了时间，没有人通知我，那么我到点儿之后自动停止等待。
         */
        //消费者1
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (LOCK) {
                        System.out.println("顾客1: 老板来份肠粉!!!!!");
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客1正在疯狂吞食肠粉");
                        System.out.println("===================================");
                    }
                }
            }
        }).start();

        //消费者2
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (LOCK) {
                        System.out.println("顾客2: 老板来份肠粉!!!!!");
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客2正在疯狂吞食肠粉");
                        System.out.println("===================================");
                    }
                }
            }
        }).start();

        //生产者
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (LOCK) {
                        //LOCK.notify();//如果有多个等待线程,随机唤醒一个
                        LOCK.notifyAll();//唤醒所有等待的线程
                        System.out.println("肠粉做好了!趁热吃");
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        //demo_WaitingAndNotify();
        demo_TimeWaiting();
    }
}
