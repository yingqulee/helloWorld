package Base_JAVA.base_15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    java.util.list接口 extends Collection 接口
    List接口的特点:
        1.有序的集合,存储元素和取出元素的顺序是一致的(存123 取123)
        2.有索引,包含一些带索引的方法
        3,允许储存重复的元素

    List接口中带索引的方法(特有)
       -public void add(int index, E element) : 将指定的元素，添加到该集合中的指定位置上。
       -public E get(int index) : 返回集合中指定位置的元素。
       -public E remove(int index) : 移除列表中指定位置的元素, 返回的是被移除的元素。
       -public E set(int index, E element) : 用指定元素替换集合中指定位置的元素,返回值的更新前的元素。

    注意:
        在操作索引的时候,一定要防止索引越界异常
 */
public class demo_List {

    public static void demo_01_List(){//查询快,增删慢
        //穿件一个List集合对象,多态写法
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("a");
        System.out.println(list);

        //-public void add(int index, E element) : 将指定的元素，添加到该集合中的指定位置上。
        list.add(3,"理迎趣");
        System.out.println(list);

        //-public E remove(int index) : 移除列表中指定位置的元素, 返回的是被移除的元素。
        String s = list.remove(2);
        System.out.println(s);
        System.out.println(list);

        //-public E set(int index, E element) : 用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
        list.set(5,"我是a,我被替换了");
        System.out.println(list);

        //-public E get(int index) : 返回集合中指定位置的元素。
        //1.使用普通for 2.使用迭代器 3.使用增强for
    }

    public static void demo_02_LinkedList(){
        /*
            java.util.LinkedList集合 implements List接口 : LinkedList是List的子类，List中的方法LinkedList都是可以使用
            LinkedList集合的特点:
                1.底层是一个链表结构:查询慢,增删慢
                2.里边包含了大量操作首尾元素的方法
                3.注意: 使用LinkedList集合特有的方法,不能使用多态

            -public void addFirst(E e) :将指定元素插入此列表的开头。
            -public void addLast(E e) :将指定元素添加到此列表的结尾。
            -public void push(E e) : 将元素推入此列表所表示的堆栈。

            -public E getFirst() :返回此列表的第一个元素。
            -public E getLast() :返回此列表的后一个元素。

            -public E removeFirst() : 移除并返回此列表的第一个元素。
            -public E removeLast() : 移除并返回此列表的后一个元素。
            -public E pop() : 从此列表所表示的堆栈处弹出一个元素。

            -public boolean isEmpty() ：如果列表不包含元素，则返回true。
         */
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);

        //linked.addFirst("www.");
        //linked.addLast(".com");
        //linked.push("www.");//与add方法一样

        /*if (!linked.isEmpty()){
            System.out.println(linked.getFirst());
            System.out.println(linked.getLast());
        }*/

        //System.out.println(linked.removeFirst());
        //System.out.println(linked.removeLast());

        /*String s = linked.pop();
        System.out.println(s);*/

        System.out.println(linked);
    }

    public static void main(String[] args) {

        //demo_01_List();
        demo_02_LinkedList();
    }
}
