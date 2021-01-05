package Base_JAVA.base_14;

import java.util.ArrayList;
import java.util.Collection;

/*
   增强for循环(也称for each循环)是JDK1.5以后出来的一个高级for循环，专门用来[遍历数组和集合]的。
   它的内部原理其实是个Iterator迭代器，所以在遍历的过程中，不能对集合中的元素进行增删操作。

   格式: for(集合/数组的数据类型 变量名 : 集合名/数组名){
            //输出
   }
 */
public class demo_Foreach {

    public static void demo_01_Foreach(){
        /*double[] array = { 1.5, 5.6, 3.7 };
        for (double num : array) { // double num = array[i];
            System.out.println(num);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        for (String str:list) {
            System.out.println(str);
        }*/

        /*
        如果使用增强for循环，那么无法改变基本类型容器的数据值，同时也无法改变引用类型容器的地址值。

        注意：不能改变的是地址值，但是可以通过地址值调用成员方法，从而改变具体对象的内容。
        也就是说：集合里面换一个别的对象，是不行的；但是这个对象肚子里面的内容，是可以改变的。
         */
        Collection<Person> coll = new ArrayList<>();
        coll.add(new Person("鹿晗", 20));
        coll.add(new Person("吴亦凡", 20));

        System.out.println(coll); // [Person{name='鹿晗', age=20}, Person{name='吴亦凡', age=20}]

        for (Person person : coll) {// Person person = iter.next()
            person.setAge(40);
        }

        System.out.println(coll);
    }

    public static void main(String[] args) {
        //demo_01_Foreach();
    }
}
