package Base_JAVA.base_25;

import java.util.ArrayList;
import java.util.List;

public class demo_Stream {
    /*
        每当我们需要对集合中的元素进行操作的时候，总是需要进行循环、循环、再循环。这是理所当然的么？不是。循
        环是做事情的方式，而不是目的。另一方面，使用线性循环就意味着只能遍历一次。如果希望再次遍历，只能再使
        用另一个循环从头开始。
     */
    private static void demo01(){
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }
        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                shortList.add(name);
            }
        }
        for (String name : shortList) {
            System.out.println(name);
        }
    }

    //Lambda的衍生物Stream能给我们带来怎样更加优雅的写法
    private static void demo02(){
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        demo01();
        System.out.println("============");
        demo02();
    }
}
