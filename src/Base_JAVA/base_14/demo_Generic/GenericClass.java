package Base_JAVA.base_14.demo_Generic;

/*
    定义个含有泛型的类,模拟ArrayList集合
    泛型是一个位置的数据类型,当我们不确定什么数据类型的时候,就可以使用泛型
    泛型可以接受任意数据类型,可以使用Integer..String..Student..
    创建对象的时候确定泛型的数据类型
 */
public class GenericClass<E> {//泛型的类

    private E param;

    public E getParam() {
        return param;
    }

    public void setParam(E param) {
        this.param = param;
    }
}
