package Base_JAVA.base_18;

public class Consumer implements Runnable{

    //1.需要在成员位置创建一个成品变量
    private Product product;

    //2.使用带参数构造方法,为变量赋值
    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {

        while(true){
            //使用同步锁
            synchronized (product){
                if (product.flag == false){
                    //没有成品让消费者消费,消费者进入等待
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("正在购物的是: "+product.name+", "+product.money);
                product.flag = false;

                product.notify();
                System.out.println("消费完,回家! 老板快点加仓吧");
                System.out.println("================================");
            }
        }
    }
}
