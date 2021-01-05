package Base_JAVA.base_14.demo_Generic;

import java.util.ArrayList;

/*
泛型:可以在类或方法中预支地使用未知的类型

使用泛型的好处：
1. 保证类型安全，让当中数据类型统一。
2. 将可能发生的类型安全问题，从运行期提前到编译期。（有问题，早点暴露；别等到程序运行的时候，再崩溃。）
3. 对于集合来说，省去向下转型的麻烦。
4. 让代码模板化。

自定义泛型的三种用法：
1. 泛型类 : 修饰符 class 类名<代表泛型的变量> {  }
2. 泛型接口 : 修饰符 <代表泛型的变量> 返回值类型 方法名(参数){  }
3. 泛型方法08- : 修饰符 interface接口名<代表泛型的变量> {  }
 */
public class demo_GenericPractice {

    public static void demo_01_GenericClass(){
        //不写泛型默认就是Object类型
        GenericClass gc1 = new GenericClass();
        gc1.setParam("哈哈哈哈");
        Object o = gc1.getParam();

        //创建Integer类型
        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setParam(10);
        Integer integer = gc2.getParam();
        System.out.println(integer);

        //创建String类型
        GenericClass<String> gc3 = new GenericClass<>();
        gc3.setParam("我是字符串");
        String s = gc3.getParam();
        System.out.println(s);

    }

    public static void demo_02_GenericMethod(){
        /*
            测试含有泛型的方法
         */
        GenericMethod gm = new GenericMethod();
        //传递什么类型,泛型就是什么类型
        gm.method("我是字符串");
        gm.method(100);
        gm.method(true);

        //静态方法可以通过类名.方法名(参数)直接使用
        //gm.methodStatic("静态方法!不建议创建对象使用");
        GenericMethod.methodStatic("静态方法可以通过类名.方法名(参数)直接使用");
    }

    public static void demo_03_GenericInterface(){
        /*//创建第一种实现类对象
        GenericInterfaceImpl gi1 = new GenericInterfaceImpl();
        gi1.method("实现了String类型");*/

        //创建第二种实现类对象
        GenericInterfaceImpl<Integer> gi2 = new GenericInterfaceImpl<>();
        gi2.method(100);

        GenericInterfaceImpl<Double> gi3 = new GenericInterfaceImpl<>();
        gi3.method(10.23);
    }

    public static void demo_04_GenericElement(ArrayList<?> list){
        /*
            泛型的通配符: 不知道使用什么类型来接受的时候,此时可以用 ? 来表示未知通配符
            注意:
                泛型没有继承概念的
         */
        //1.使用增强for循环
        /*for (Object o : list) {
            System.out.println(o);
        }*/
        //2.使用迭代器
        /*Iterator<?> it = list.iterator();
        while(it.hasNext()){
            //it.next()方法,取出的元素是Object,可以接受任意的数据类型
            Object o = it.next();
            System.out.println(o);
        }*/
    }

    /*//泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement1(Collection<? extends Number> coll){}
    //泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll){}*/

    public static void main(String[] args) {

        //泛型的概念与好处
        /*Collection<String> coll = new ArrayList<>();

        coll.add("Hello");
        coll.add("JavaMoney");
        //coll.add(100); // 错误！

        for (String s : coll) {
            System.out.println(s.length());
        }*/

        //定义一个泛型的类
        //demo_01_GenericClass();

        //定义一个泛型的方法
        //demo_02_GenericMethod();

        //定义一个泛型的接口
        //demo_03_GenericInterface();

        /*
        泛型的通配符 : ? 代表任意类型
        使用方式: 不能创建对象使用,只能作为方法的参数使用
         */
        /*ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("你很牛?");
        list2.add("还可以!");
        list2.add("有点吧!");

        //不可以使用泛型通配符这样定义
        //ArrayList<?> list2 = new ArrayList<?>();

        demo_04_GenericElement(list1);
        demo_04_GenericElement(list2);*/

        //泛型通配符的高级使用
        /*Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();

        getElement1(list1);
        getElement1(list2);//报错     
        getElement1(list3);
        getElement1(list4);//报错        
        getElement2(list1);//报错     
        getElement2(list2);//报错    
        getElement2(list3);
        getElement2(list4);*/
    }


}
