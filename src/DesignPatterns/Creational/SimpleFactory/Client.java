package DesignPatterns.Creational.SimpleFactory;

public class Client {

    public static void main(String[] args) {
        /**
         * 以下的 Client 类包含了实例化的代码，这是一种错误的实现。
         * 如果在客户类中存在这种实例化代码，就需要考虑将代码放到简单工厂中。
         */
//        int type = 1;
//        Product product;
//        if (type == 1) {
//            product = new ConcreteProduct1();
//        } else if (type == 2) {
//            product = new ConcreteProduct2();
//        } else {
//            product = new ConcreteProduct3();
//        }
//        product.method();

        /**
         * 以下的 SimpleFactory 是简单工厂实现，它被所有需要进行实例化的客户类调用
         */
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(5);
        product.method();
    }
}
