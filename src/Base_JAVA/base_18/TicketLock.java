package Base_JAVA.base_18;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    解决线程安全问题的第三种方案: 使用Lock锁
    java.util.concurrent.locks.lock接口
    lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作
    lock接口中的方法
        public void lock() :加同步锁。
        public void unlock() :释放同步锁。
    java.util.concurrent.locks.ReentrantLock implements lock接口

    使用步骤:
        1.在成员位置创建一个Reentrantlock对象
        2.在可能会出现安全问题的代码前调用lock接口中的方法lock获取锁
        3.在可能会出现安全问题的代码后调用lock接口中的方法unlock释放锁

 */
public class TicketLock implements Runnable {

    private int ticket = 100;

    //1.在成员位置创建一个Reentrantlock对象
    Lock lock1 = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            //2.在可能会出现安全问题的代码前调用lock接口中的方法lock获取锁
            lock1.lock();

            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "正在出售: " + ticket--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //3.在可能会出现安全问题的代码后调用lock接口中的方法unlock释放锁
                    lock1.unlock();//无论程序是否异常,都会释放lock锁,提高程序的效率
                }
            }
        }
    }
}
