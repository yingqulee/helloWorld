package Base_JAVA.base_15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
    java.util.Set接口和java.util.List接口一样，同样继承自 Collection 接口，
    它与 Collection 接口中的方法基本一致，并没有对 Collection 接口进行功能上的扩充，只是比 Collection 接口更加严格了。
    与 List 接口不同的是， Set接口中元素无序，并且都会以某种规则保证存入的元素不出现重复。

    java.util.HashSet集合 implements Set接口
        HashSet特点:
            1.不允许存储重复元素.
            2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历
            3.是一个无序的集合,存储元素和取出顺序可能不一致
            4.底层是一个Hash表结构(查询速度非常快)
 */
public class demo_Set {

    public static void demo_01_HashSet(){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);//不允许存储重复遍历

        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void demo_02_HashCode(){
        /*
            Hash值:是一个十进制整数,由系统随机给出(就是对象的地址值,是一个逻辑地址,是模拟出来的地址,不是数据实际存储的物理地址)
            在Object类有一个方法,可以得到对象的hash值
            int hashCode() 返回该对象的哈希码值
                public native int hashCode();
                native:代表方法调用的是本地操作系统的方法
         */
        Person p1 = new Person();
        System.out.println(p1.hashCode());//对象的地址值,是一个逻辑地址,是模拟出来的地址
    }

    public static void demo_03_HashSetSavePerson(){
        /*
            HashSet存储自定义类型元素
            必须重写hashcode()和equals()方法
         */
        HashSet<Person> setPerson = new HashSet<>();
        Person p1 = new Person("土豆",19);
        Person p2 = new Person("土豆",19);
        Person p3 = new Person("番茄",19);

        setPerson.add(p1);
        setPerson.add(p2);
        setPerson.add(p3);
        System.out.println(setPerson);
    }

    public static void demo_04_LinkedHashSet(){
        /*
            java.util.LinkedHashSet集合 extends HashSet集合
            LinkedHashSet集合特点:
                底层是一个哈希表(数组+链表/数组+红黑数)+链表:多了一个链表(记录元素的存储顺序),保证了元素的有序
         */
        HashSet<String> set = new HashSet<>();
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        System.out.println(set);//调换位置前:[aaa, ccc, bbb] 调换位置后: [aaa, ccc, bbb]

        //存取有序,不允许重复
        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("aaa");
        linked.add("aaa");
        linked.add("bbb");
        linked.add("ccc");
        System.out.println(linked);//调换位置前:[aaa, ccc, bbb] 调换位置后: [aaa, bbb, ccc]
    }

    public static void demo_05_ChangeArgs(){
        /*
            可变参数:是JDK1.5之后出现的新特性
            使用前提:
                当方法的参数列表数据类型已经确定,但是参数的个数不确定,就可以使用可变参数
                格式: 定义方法时使用
                    修饰符 返回值类型 方法名(数据类型...变量名){}
                可变参数的原理:
                    可变参数底层就是一个数组,根据传递参数个数的不同,会创建不同长度的数组,存储参数
                    传递参数的个数,可以是0个,1,2,...,多个参数
         */
        int num1 = add(10);
        int num2 = add(10,20);
        int num3 = add(10,20,30);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

    //定义计算(0-n)整数和的方法 数据类型为int 参数个数不知道,可以用可变参数
    public static int add(int...arr){
        //System.out.println(arr);//底层是一个数组 打印的是地址
        //System.out.println(arr.length);
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        //demo_01_HashSet();
        //demo_02_HashCode();
        //demo_03_HashSetSavePerson();
        //demo_04_LinkedHashSet();
        demo_05_ChangeArgs();
    }
}
