package Base_JAVA.base_08;
/*
1.从java 8 开始,接口允许定义默认方法

格式:
    public default 返回值类型 方法名称(参数列表) {
        方法体
    }
备注: 接口当中的默认方法,可以解决接口升级的问题

2.从java 8 开始,接口允许定义静态方法

格式:
    public static 返回值类型 方法名称(参数列表) {
        方法体
    }
提示:就是将abstract或者default换成static即可.

3.接口的私有方法定义:
    问题描述:我们需要抽取一个共有方法,用来解决两个默认方法之间重复代码的问题.
    但是这个共有方法不应该让实现类使用,应该私有化

    解决方法:从java 9 开始,接口允许定义私有方法
    1.普通私有方法,解决多个默认方法之间重复代码问题
    格式: private 返回值类型 方法名称(参数列表){
           方法体
    }
    2.静态私有方法,解决多个静态方法之间重复代码问题
    格式: private static 返回值类型 方法名称(参数列表){
           方法体
    }

4.接口当中也可以定义"成员变量",但是必须使用 public static final三个关键字进行修饰.
  从效果上看,这其实就是接口的[常量]
  格式:
  public static final 数据类型 常量名称 = 数据值;
  final 关键字--不可改变

  1.接口当中的常量.可以省略public static final,注意,不写也照样是这样
  2.接口当中的常量,必须进行赋值,不能不赋值
  3.接口当中常量的名称,使用完全大写的字母,用下划线进行分割(推荐命名)
 */

public interface MyInterfacePractice {

    //抽象方法
    public abstract void method1();

    //抽象方法
    void method2();

    //抽象方法
    public void method3();

    //抽象方法
    abstract void method4();

    //新添加的方法改成默认的方法
    public default void methodDefault(){
        System.out.println("这是新添加的默认方法");
    }

    public  static void methodStatic(){
        System.out.println("这是接口的静态方法");
    }

    //接口的私有方法定义
    //1.默认私有方法
    /*public default void methodDefault1(){
        System.out.println("默认方法1");
        methodCommon();
    }

    public default void methodDefault2(){
        System.out.println("默认方法2");
        methodCommon();
    }

    private void methodCommon(){
        System.out.println("111");
        System.out.println("222");
        System.out.println("333");
    }*/
    //2.静态私有方法
    /*public static void methodStatic1(){
        System.out.println("静态方法1");
        methodStaticCommon();
    }

    public static void methodStatic2(){
        System.out.println("静态方法2");
        methodStaticCommon();
    }

    private static void methodStaticCommon(){
        System.out.println("111");
        System.out.println("222");
        System.out.println("333");
    }*/

    //这是一个常量,一旦赋值,就不可以修改
    public static final int NUM = 10;
}
