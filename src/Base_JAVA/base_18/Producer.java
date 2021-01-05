package Base_JAVA.base_18;

public class Producer implements Runnable{
    //1.需要在成员位置创建一个成品变量
    private Product product;

    //2.使用带参数构造方法,为变量赋值
    public Producer(Product product) {
        this.product = product;
    }

    //设置线程任务:生成者开始工作
    @Override
    public void run() {

        int count = 0;

        while(true){
            //使用同步锁
            synchronized (product){
                if (product.flag== true){
                    //调用wait方法进入等待
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒之后执行,生成者开始工作
                if (count % 2 == 0) {
                    product.name = "吴彦祖";
                    product.money = "又帅又多金,京东商城:启动";
                } else {
                    product.name = "彭于晏";
                    product.money = "又帅又多金,淘宝商城:启动";
                }
                count++;
                System.out.println("姓名: "+ product.name +", "+ product.money);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //睡醒之后,修改状态
                product.flag = true;
                product.notify();
                System.out.println("网购一时爽,一直网购一直爽");
            }
        }
    }
}
