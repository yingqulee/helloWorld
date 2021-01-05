package Base_JAVA.base_09;

//键盘USB设备
public class KeyBoard implements USB {

    @Override
    public void open() {
        System.out.println("键盘已插入");
    }

    @Override
    public void close() {
        System.out.println("键盘已拔出");
    }

    //自己的方法
    public void input(){
        System.out.println("大招已冷却完毕");
    }
}
