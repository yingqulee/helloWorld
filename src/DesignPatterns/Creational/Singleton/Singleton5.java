package DesignPatterns.Creational.Singleton;

/**
 * 简述:确保一个类只有一个实例，并提供该实例的全局访问点。
 * 类图:
 *     使用一个私有构造函数、一个私有静态变量以及一个公有静态函数来实现。
 *     私有构造函数保证了不能通过构造函数来创建对象实例，只能通过公有静态函数返回唯一的私有静态变量。
 */
public class Singleton5 {
    /**V 静态内部类实现
     * 当 Singleton 类被加载时，静态内部类 SingletonHolder 没有被加载进内存。
     * 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时 SingletonHolder 才会被加载，
     * 此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。
     *
     * 这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
     */
    private Singleton5() {}

    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
