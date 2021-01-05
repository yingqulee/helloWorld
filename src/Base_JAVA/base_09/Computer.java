package Base_JAVA.base_09;

public class Computer {

    public void powerOn(){
        System.out.println("英雄联盟启动!");
    }

    public void powerOff(){
        System.out.println("凸(艹皿艹 )!卸载游戏");
    }

    //使用USB设备
    public  void useDevice(USB usb){
        usb.open();
        if (usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.click();
        }else if (usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.input();
        }
        usb.close();
    }
}
