package Base_JAVA.base_09;

public class Cat extends Animals {

    @Override
    public void eat() {
        System.out.println("吃鱼鱼");
    }

    //子类特有方法
    public void catchMouse(){
        System.out.println("抓鼠鼠");
    }
}
