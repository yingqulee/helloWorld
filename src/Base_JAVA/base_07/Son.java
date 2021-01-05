package Base_JAVA.base_07;

public class Son extends Father{

    public Son(){
        System.out.println("子类构造方法执行");
    }

    @Override
    public void eat() {
        System.out.println("吃屁屁!");
    }
}
