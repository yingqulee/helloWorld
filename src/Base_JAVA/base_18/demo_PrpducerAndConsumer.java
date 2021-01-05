package Base_JAVA.base_18;

public class demo_PrpducerAndConsumer {

    public static void main(String[] args) {
        //创建产品
        Product product = new Product();

        //创建生产者
        new Thread(new Producer(product)).start();
        new Thread(new Consumer(product)).start();
    }
}
