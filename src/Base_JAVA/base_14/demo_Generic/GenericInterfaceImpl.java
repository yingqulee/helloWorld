package Base_JAVA.base_14.demo_Generic;

/*
    含有泛型的接口,第一种使用方法:定义接口的实现类,实现接口,指定接口的泛型

    含有泛型的接口,二种使用方法:接口使用寿命泛型,实现类就使用什么泛型,类跟着接口走
 */

/*//第一种使用方法
public class GenericInterfaceImpl implements GenericInterface<String>{

    @Override
    public void method(String s) {
        System.out.println(s);
    }
}*/

//第二种使用方法
public class GenericInterfaceImpl<i> implements GenericInterface<i>{

    @Override
    public void method(i i) {
        System.out.println(i);
    }
}


