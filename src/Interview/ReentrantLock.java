package Interview;

/**
 * 可重入就是说某个线程已经获得某个锁，可以再次获取锁而不会出现死锁。
 * 而锁的操作粒度是”线程”,而不是调用(至于为什么要这样,下面解释).
 * 同一个线程再次进入同步代码的时候. 可以使用自己已经获取到的锁,这就是可重入锁.
 *
 * 在一个synchronized修饰的方法或代码块的内部
 * 调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的
 */
public class ReentrantLock {

    

    public static void main(String[] args) {

    }
}
