package Base_JAVA.base_24;
/*
   函数式接口:有且只有一个抽象方法的接口,称之为函数式接口
   当然接口中科院包含其他的方法(默认,静态,私有)

   @FunctionalInterface注解 : 检测接口是否是含有一个函数式接口
 */
@java.lang.FunctionalInterface
public interface FunctionalInterface {
    void method();

    //void method1();
}
