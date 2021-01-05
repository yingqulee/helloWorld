package DesignPatterns.Creational.Singleton;

/**
 * 简述:确保一个类只有一个实例，并提供该实例的全局访问点。
 * 类图:
 *     使用一个私有构造函数、一个私有静态变量以及一个公有静态函数来实现。
 *     私有构造函数保证了不能通过构造函数来创建对象实例，只能通过公有静态函数返回唯一的私有静态变量。
 */
public class Singleton3 {
    /**实现: III 懒汉式-线程安全
     * 只需要对 getUniqueInstance() 方法加锁，那么在一个时间点只能有一个线程能够进入该方法，从而避免了实例化多次 uniqueInstance。
     *
     * 但是当一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，即使 uniqueInstance 已经被实例化了。这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用。
     */
    private static Singleton3 uniqueInstance;

    private Singleton3() {}

    public static synchronized Singleton3 getUniqueInstancne() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton3();
        }
        return uniqueInstance;
    }
}
