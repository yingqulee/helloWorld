package DesignPatterns.Creational.Singleton;

/**
 * 简述:确保一个类只有一个实例，并提供该实例的全局访问点。
 * 类图:
 *     使用一个私有构造函数、一个私有静态变量以及一个公有静态函数来实现。
 *     私有构造函数保证了不能通过构造函数来创建对象实例，只能通过公有静态函数返回唯一的私有静态变量。
 */
public class Singleton1 {
    /**实现: I 懒汉式-线程不安全
     * 以下实现中，私有静态变量 uniqueInstance 被延迟实例化，这样做的好处是，如果没有用到该类，那么就不会实例化 uniqueInstance，从而节约资源。
     * 这个实现在多线程环境下是不安全的，如果多个线程能够同时进入 if (uniqueInstance == null) ，
     * 并且此时 uniqueInstance 为 null，那么会有多个线程执行 uniqueInstance = new Singleton(); 语句，这将导致实例化多次 uniqueInstance
     */
    private static Singleton1 uniqueInstance;

    private Singleton1() {}

    public static Singleton1 getUniqueInstancne() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}
