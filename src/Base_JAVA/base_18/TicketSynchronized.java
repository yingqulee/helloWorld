package Base_JAVA.base_18;

public class TicketSynchronized implements Runnable{

    private static int ticket = 100;

    /*
        解决线程安全问题的第一种方案:使用同步代码块
        格式:
            synchronized(锁对象){
                可能会出现线程安全问题的代码(访问了共享数据的代码)
            }

        注意:
            1.通过代码块中的锁对象,可以使用任意的对象
            2.但是必须保证多个线程使用的锁对象是同一个
            3.锁对象作业:
                把同步代码块锁住,只让一个线程在同步代码块中执行
     */
    //创建一个锁对象
    Object object = new Object();//在方法外面

    @Override
    public void run() {
        //死循环,卖票
        while(true) {
            //1.同步代码块:同步中的线程,没有执行完毕不会释放同步,同步外的线程没有锁进不去同步
            /*synchronized (object){//缺点:程序频繁的判断锁,获取锁,释放锁,程序的效率会降低
                if (ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在出售: "+ticket--);
                }
            }*/
            //2.同步方法
            //sellTicket();

            //3.静态同步方法
            sellStaticTicket();
        }
    }

    /*
        解决线程安全问题的第二种方案:使用同步方法
        使用步骤:
            1.把访问了共享数据的代码抽取出来,放到一个方法中
            2.在方法上添加synchronized修饰符

        格式:定义方法的格式
        修饰符:synchronized 返回值类型 方法名(参数)
     */
    /*public *//*synchronized*//* void sellTicket(){
        synchronized(this) {//这样也是可以的
            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在出售: " + ticket--);
            }
        }
    }*/

    /*
        使用静态同步方法
        锁对象不能是this,this是对象创建之后产生的,静态方法优先于对象(静态是在创建对象之前就进入内存了)
        静态方法的锁对象是本类的class属性-->class文件对象(反射原理)
     */
    public static synchronized void sellStaticTicket() {
        synchronized (TicketSynchronized.class) {//this就不行,要使用Ticket.class(也就是本类)
            if (ticket > 0) {//方法是静态的,变量也要是静态的
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在出售: " + ticket--);
            }
        }
    }

}
