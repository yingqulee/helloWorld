package Base_JAVA.base_06;

//定义一个父类
public class Father {

    /*int Fathernum = 10;

    int num = 100;

    public void FatherMethod(){
        System.out.println("父类方法执行!");
//        System.out.println(num);
    }
    public void sameMethod(){
        System.out.println("父类重名方法执行!");
    }

    public void method(){

    }*/
    public Father(){
        System.out.println("父类无参构造方法执行!");
    }

    //可以通过super关键字来子类构造调用父类重载构造
    public Father(int num){
        System.out.println("父类有参构造方法执行!");
    }
}
