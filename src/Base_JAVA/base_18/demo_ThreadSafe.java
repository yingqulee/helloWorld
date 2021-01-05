package Base_JAVA.base_18;

/*
    多线程访问共享数据是不安全的
 */
public class demo_ThreadSafe {

    public static void demo_Ticket(){
        TicketSynchronized ticketSynchronized = new TicketSynchronized();

        new Thread(ticketSynchronized,"窗口1").start();
        new Thread(ticketSynchronized,"窗口2").start();
        new Thread(ticketSynchronized,"窗口3").start();
        //1. 相同的票数,比如5这张票被卖了两回。
        //2. 不存在的票，比如0票与-1票，是不存在的。
    }

    public static void demo_TicketSynchronizedBock(){
        //使用synchronized(锁对象) 解决线程安全问题
        TicketSynchronized ticketSynchronized = new TicketSynchronized();

        new Thread(ticketSynchronized,"窗口1").start();
        new Thread(ticketSynchronized,"窗口2").start();
        new Thread(ticketSynchronized,"窗口3").start();
    }

    public static void demo_TicketSynchronizedMethod(){
        //使用同步方法解决线程安全问题
        TicketSynchronized ticketSynchronized = new TicketSynchronized();

        new Thread(ticketSynchronized,"窗口1").start();
        new Thread(ticketSynchronized,"窗口2").start();
        new Thread(ticketSynchronized,"窗口3").start();
    }

    public static void demo_TicketStaticSynchronizedMethod(){
        //使用同步方法解决线程安全问题
        TicketSynchronized ticketSynchronized = new TicketSynchronized();

        new Thread(ticketSynchronized,"窗口1").start();
        new Thread(ticketSynchronized,"窗口2").start();
        new Thread(ticketSynchronized,"窗口3").start();
    }

    public static void demo_TicketLock(){
        //使用Lock锁
        TicketLock ticketLock = new TicketLock();

        new Thread(ticketLock,"窗口1").start();
        new Thread(ticketLock,"窗口2").start();
        new Thread(ticketLock,"窗口3").start();

    }

    public static void main(String[] args) {
        //demo_Ticket();
        //demo_TicketSynchronizedBock();
        //demo_TicketSynchronizedMethod();
        //demo_TicketStaticSynchronizedMethod();
        //demo_TicketLock();
    }
}
