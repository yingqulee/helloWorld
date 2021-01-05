package Base_JAVA.base_14;

import java.util.ArrayList;
import java.util.Collection;

/*
集合是java中提供的一种容器，可以用来存储多个数据。集合和数组既然都是容器，它们有啥区别呢？
1.数组的长度是固定的。集合的长度是可变的。
2.数组中存储的是同一类型的元素，可以存储基本数据类型值。
  集合存储的都是对象。而且对象的类型可以不一致。在开发中一般当对象多的时候，使用集合进行存储

  Collection:单列集合类的根接口，用于存储一系列符合某种规则的元素，它有两个重要的子接口，
  分别是 java.util.List 和 java.util.Set.
         △List 的特点是[元素有序、元素可重复,有索引]
         △Set 的特点是[元素无序，元素不可重复,无索引]
              :List 接口的主要实现类有 java.util.ArrayList 和 java.util.LinkedList,
              :Set 接口 的主要实现类有 java.util.HashSet 和 java.util.TreeSet,

   共性的方法:
   public boolean add(E e): 把给定的对象添加到当前集合中.
   public void clear(): 清空集合中所有的元素.
   public boolean remove(E e): 把给定的对象在当前集合中删除.
   public boolean contains(E e): 判断当前集合中是否包含给定的对象.
   public boolean isEmpty(): 判断当前集合是否为空
   public int size(): 返回集合中元素的个数.
   public Object[] toArray(): 把集合中的元素，存储到数组中.
 */
public class demo_Collection {

    public static void demo_01_Collection(){
        //创建集合对象,可以使用多态
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);//重写了toString方法 结果:[]

        //1.public boolean add(E e): 把给定的对象添加到当前集合中.返回值[boolean]
        boolean b1 = coll.add("小李广花荣");
        System.out.println(b1);//true

        coll.add("黑旋风李逵");
        coll.add("及时雨宋江");
        coll.add("豹子头林冲");
        System.out.println(coll);//[小李广花荣, 黑旋风李逵, 及时雨宋江, 豹子头林冲]

        //2.public boolean remove(E e): 把给定的对象在当前集合中删除.返回值[boolean]
        boolean b2 = coll.remove("豹子头林冲");
        System.out.println(b2);//true

        boolean b3 = coll.remove("智多星无用");
        System.out.println(b3);//false
        System.out.println(coll);//[小李广花荣, 黑旋风李逵, 及时雨宋江]

        //3.public boolean contains(E e): 判断当前集合中是否包含给定的对象.
        boolean b4 = coll.contains("及时雨宋江");
        System.out.println(b4);//true

        //4.public boolean isEmpty(): 判断当前集合是否为空
        boolean b5 = coll.isEmpty();
        System.out.println(b5);//false 集合不为空

        //5.public int size(): 返回集合中元素的个数.
        int size = coll.size();
        System.out.println(size);

        //6.public Object[] toArray(): 把集合中的元素，存储到数组中.
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //7.public void clear(): 清空集合中所有的元素.不删除集合
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());
    }

    public static void main(String[] args) {
       //demo_01_Collection();
    }
}
