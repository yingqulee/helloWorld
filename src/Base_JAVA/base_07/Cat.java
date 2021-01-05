package Base_JAVA.base_07;

//覆盖重写(实现):子类去掉抽象方法的abstract关键字,然后补上方法体的大括号
public abstract class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("猫吃屁股!");
    }

    /* public void sleep();*/
}
