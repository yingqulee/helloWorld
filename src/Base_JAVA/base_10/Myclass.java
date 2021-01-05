package Base_JAVA.base_10;

/*
当final关键字用来修饰一个类的时候,当前这个类不能有任何子类.(断子绝孙类)
注意:一个类如果是final,那么其中所有的成员方法都无法进行覆盖重写.
 */
public final class Myclass {

    public void method(){
        System.out.println("这是一个断子绝孙类,不能有任何子类");
    }


}
