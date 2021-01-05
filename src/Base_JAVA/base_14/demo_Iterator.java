package Base_JAVA.base_14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    并不是所有的集合都有索引值，所以对于Collection来说，普通for循环的变量索引i那种写法不一定适用。

    有一个叫做“迭代器”的工具，专门用来进行遍历，可以通用于所有Collection集合。

    步骤：
    1. 根据集合获取一个迭代器对象。（可不是自己new迭代器，而是从集合中获取。）
    2. 通过迭代器，看看有没有下一个。
    3. 如果有下一个，通过迭代器获取下一个，并且向后移动一个小格。
    4. 循环，直到没有下一个为止。（while循环）

    java.util.Iterator<T>接口代表迭代器，其中有两个常用的方法：
    boolean hasNext()：判断有没有下一个元素
    T next()：获取下一个元素，并且向后移动一个小格
 */
public class demo_Iterator {
    /*
      在使用迭代器的过程当中，一定要避免直接通过集合改变其中元素的个数。
      如果不听话，不乖，那么将会发生并发修改异常：ConcurrentModificationException。
     */

    public static void demo_01_Iterator(){
        Collection<String> coll = new ArrayList<>();
        coll.add("迪丽热巴");
        coll.add("古力娜扎");
        coll.add("玛尔扎哈");

        // 1. 根据集合对象获取迭代器,每个集合对象都有自己的迭代器
        Iterator<String> iter = coll.iterator();

        while (iter.hasNext()) { // 2. 通过迭代器看看有没有下一个

            // 3. 如果有，取出下一个，并且向后一格
            String name = iter.next();
            //coll.add("高圆圆"); // 错误写法！将会发生异常！
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        demo_01_Iterator();
    }
}
