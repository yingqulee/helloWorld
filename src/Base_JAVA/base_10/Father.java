package Base_JAVA.base_10;

/*
当final关键字用来修饰一个方法的时候,这个方法就是最终方法,也就是不能被覆盖重写

注意事项:
    对于类,方法来说,abstract关键字和final关键字不能同时使用,因为矛盾
 */
public class Father {

    public void method(){
        System.out.println("这是一个普通父类");
    }

    public final void methodFinal(){
        System.out.println("最终方法!不能被覆盖重写");
    }
}
