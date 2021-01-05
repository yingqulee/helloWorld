package Base_JAVA.base_09;

public class Son extends Father {

    /*@Override
    public void method(){
        System.out.println("子类方法!");
    }*/

    /*int num = 200;
    @Override
    public void showNumber() {
        System.out.println(num);
    }*/

    @Override
    public  void method(){
        System.out.println("子类方法");
    }
    public void methodSon(){
        System.out.println("子类特有方法!");
    }
}
