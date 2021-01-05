package DesignPatterns.Creational.Singleton;

/**
 * 简述:确保一个类只有一个实例，并提供该实例的全局访问点。
 * 类图:
 *     使用一个私有构造函数、一个私有静态变量以及一个公有静态函数来实现。
 *     私有构造函数保证了不能通过构造函数来创建对象实例，只能通过公有静态函数返回唯一的私有静态变量。
 */
public class Singleton2 {
    /**实现: II 饿汉式-线程安全
     * 线程不安全问题主要是由于 uniqueInstance 被实例化多次，采取直接实例化 uniqueInstance 的方式就不会产生线程不安全问题。
     *
     * 但是直接实例化的方式也丢失了延迟实例化带来的节约资源的好处。
     */
    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2() {}

    public static Singleton2 getUniqueInstancne() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }
}
