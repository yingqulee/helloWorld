package Base_JAVA.base_08;
/*
接口:是一种公共的规范标准;
接口是引用数据类型,最重要的内容就是:抽象方法

如果是java7 那么接口可以包含的内容有:1.常量 2.抽象方法
如果是java8 那么接口可以包含的内容有:1.常量 2.抽象方法 3.默认方法 4.静态方法

接口使用步骤:
1.接口不能直接使用,必须有一个"实现类"来"实现"接口
2.接口的实现类必须覆盖重写(实现)接口中所有的抽象方法.
3.创建实现类的对象,进行使用

注意事项:
如果实现类并没有覆盖重写接口中所有的抽象方法,那么这个实现类自己就必须是抽象类

接口默认方法,可以通过接口实现类对象,直接使用
接口默认方法,也可以被接口实现类进行覆盖重写

接口之间的多继承;
1.类与类之间是单继承的,直接父类只有一个.
2.类与接口之间是多实现的,一个类可以实现多个接口.
3.接口与接口之间是多继承的. 接口 extends 接口A,接口B
    注意事项: 1.多个父接口当中的抽象方法如果重复,没关系;
             2.多个父接口当中的默认方法如果重复,要覆盖重写.
 */
public class demo_01  {

    public static void main(String[] args) {

        //创建实现类的对象使用
        /*MyInterfaceIMPL myInterfaceIMPL = new MyInterfaceIMPL();
        myInterfaceIMPL.method1();
        myInterfaceIMPL.method2();
        myInterfaceIMPL.method3();
        myInterfaceIMPL.method4();*/

        //接口默认方法的使用
        /*MyInterfaceIMPL myInterfaceIMPL = new MyInterfaceIMPL();
        myInterfaceIMPL.methodDefault();*/

        //接口静态方法的使用
        //注意:不能通过接口实现类的对象来调用接口当中的静态方法
        //格式: 接口名称.静态方法();
       /* MyInterfaceIMPL myInterfaceIMPL = new MyInterfaceIMPL();
        //myInterfaceIMPL.methodStatic();错误写法
        MyInterfacePractice.methodStatic();//直接通过接口名称调用静态方法*/

       //接口的私有方法的使用,直接接口名称.方法
        /*MyInterfacePractice.methodStatic1();
        MyInterfacePractice.methodStatic2();*/

        //访问接口当中的常量
        //System.out.println(MyInterfacePractice.NUM);

    }
}
