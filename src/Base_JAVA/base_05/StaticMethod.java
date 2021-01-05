package Base_JAVA.base_05;

public class StaticMethod {

    int num;//成员变量
    static int numStatic;

    public void method(){
        System.out.println("普通方法");
        /*//成员方法可以访问成员变量
        System.out.println(num);//正确写法
        //成员方法可以访问静态变量
        System.out.println(numStatic);//正确写法*/
    }

    public static void methodStatic(){
        System.out.println("静态方法");
        /*//静态方法不可以直接访问成员变量
        System.out.println(num);//错误写法
        //静态方法可以访问静态变量
        System.out.println(numStatic);//正确写法
        //静态方法中不能使用this关键字
        System.out.println(this);*/
    }
}
