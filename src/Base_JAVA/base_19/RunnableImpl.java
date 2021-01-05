package Base_JAVA.base_19;

/*
    2. 通过Runnable接口的run方法来指定任务内容。
 */
public class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println("创建了一个新的线程: "+Thread.currentThread().getName());
    }
}
