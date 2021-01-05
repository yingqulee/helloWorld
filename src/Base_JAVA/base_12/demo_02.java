package Base_JAVA.base_12;
/*
重点:匿名内部类

1.如果接口的实现类(或者是父类的子类)只需要使用唯一一次.
    那么这种情况就可以省略该类的定义,而改为使用[匿名内部类].
    定义格式:
    接口名称 对象名 = new 接口名称(){
        //覆盖重写所有抽象方法
    };

    注意事项:
    a.适用场景:接口的实现类(或者是父类的子类)只需要使用唯一一次.
      匿名内部类在[创建对象]的时候,只能使用唯一一次,
      如果希望多次创建对象,而且类的内容一样的话,那么就必须使用单独定义的实现类了
    b.匿名对象在[调用方法]的时候,只能使用唯一一次,
      如果希望同一个对象,调用多次方法,那么必须给对象起名字
    c.匿名内部类是省略了[实现类/子类 名称],但是匿名对象是省略了[对象名称]
      匿名内部类和匿名对象不是一回事!
 */
public class demo_02 {

    public static void main(String[] args) {
        //多态写法
        /*MyInterface intface = new MyInterfacePractice();
        intface.method();*/

        //使用匿名内部类,但不是匿名对象,对象名称叫myInterface
        /*MyInterface myInterface = new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了方法,甚至你可以删掉实现类");
            }
        };
        myInterface.method();
        //既是匿名内部类,也是匿名对象
        new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了方法,甚至你可以删掉实现类");
            }
        }.method();*/

    }
}
