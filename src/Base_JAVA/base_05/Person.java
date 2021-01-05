package Base_JAVA.base_05;
//静态代码块
public class Person {

    //静态代码块的格式
    //特点:第一次用到本类,静态代码块执行唯一一次.
    //用途:用来一次性地对静态成员变量进行赋值
    static {
        System.out.println("静态代码块冲鸭!");
    }

    public  Person(){
        System.out.println("构造方法执行啦!");
    }
}

