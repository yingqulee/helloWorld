package Base_JAVA.base_09;

//鼠标就是USB设备
public class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("鼠标已插入");
    }

    @Override
    public void close() {
        System.out.println("鼠标已拔出");
    }

    //自己的方法
    public void click(){
        System.out.println("走位!走位!");
    }
}
