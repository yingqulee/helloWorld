package Base_JAVA.base_09;
/*
综合案例: 笔记本USB接口案例
 */
public class demo_02 {

    public static void main(String[] args) {
        //创建一个笔记本电脑
        Computer computer = new Computer();
        computer.powerOn();

        //创建一个鼠标USB
        USB usbMouse = new Mouse();//多态写法
        computer.useDevice(usbMouse);

        //创建一个键盘USB
        USB usbKeyBoard = new KeyBoard();//多态写法
        computer.useDevice(usbKeyBoard);

        computer.powerOff();
    }
}
