package Base_JAVA.base_15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    java.utils.Collections 是集合工具类，用来对集合进行操作。部分方法如下:
    -public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
    -public static void shuffle(List<?> list) 打乱顺序 :打乱集合顺序。
    -public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。
    -public static <T> void sort(List<T> list，Comparator<? super T> ) :将集合中元素按照指定规则排序。

    Comparator与Comparable的区别
        Comparable:自己(this)和别人(参数)进行比较,自己需要实现Comparable接口,重写比较规则compareTo方法
        Comparator:找一个第三方的裁判,比较两个

    注意:
        sort(List<T> list)使用前提
        被排序的集合里边存储的元素,必须重写Comparable,重写接口中的方法compareTo定义排序的规则

    Comparable接口排序的规则:
        this - 参数 : 升序
        参数 - this : 降序
*/
public class demo_Collections {

    public static void demo_01_Collections(){

        ArrayList<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");

        //-public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
        Collections.addAll(list,"a","c","b","e","d");
        System.out.println(list);

        //-public static void shuffle(List<?> list) 打乱顺序 :打乱集合顺序。
        Collections.shuffle(list);
        System.out.println(list);

        //-public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。
        Collections.sort(list);
        //System.out.println(list);

        ArrayList<Person> list_person = new ArrayList<>();
        list_person.add(new Person("李逵",35));
        list_person.add(new Person("林冲",32));
        list_person.add(new Person("武松",17));

        Collections.sort(list_person);//必须重写Comparable,重写接口中的方法compareTo定义排序的规则
        //System.out.println(list_person);

        //-public static <T> void sort(List<T> list，Comparator<? super T> ) :将集合中元素按照指定规则排序。
        Collections.sort(list, new Comparator<String>() {
            //重写比较规则
            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(0);
                char c2 = o2.charAt(0);
                //return c1 - c2;//升序
                return c2 - c1;//降序
            }
        });
        System.out.println(list);
    }

    public static void main(String[] args) {
        demo_01_Collections();
    }
}
