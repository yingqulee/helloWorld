package Base_JAVA.base_25;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
    题目
    现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以
    下若干操作步骤：
    1. 第一个队伍只要名字为3个字的成员姓名；
    2. 第一个队伍筛选之后只要前3个人；
    3. 第二个队伍只要姓张的成员姓名；
    4. 第二个队伍筛选之后不要前2个人；
    5. 将两个队伍合并为一个队伍；
    6. 根据姓名创建 Person 对象；
    7. 打印整个队伍的Person对象信息。
 */
public class demo_practice {

    private static void demo_tradition(List<String> one, List<String> two){
        //1. 第一个队伍只要名字为3个字的成员姓名；
        List<String> one1 = new ArrayList<>();
        for (String name : one) {
            if (name.length()==3){
                one1.add(name);
            }
        }
        //2. 第一个队伍筛选之后只要前3个人
        List<String> one2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            one2.add(one1.get(i));
        }

        //3. 第二个队伍只要姓张的成员姓名；
        List<String> two1 = new ArrayList<>();
        for (String name : two) {
            if (name.startsWith("张")){
                two1.add(name);
            }
        }
        //4. 第二个队伍筛选之后不要前2个人；
        List<String> two2 = new ArrayList<>();
        for (int i = 2; i < two1.size(); i++) {
            two2.add(two1.get(i));
        }
        //5. 将两个队伍合并为一个队伍；
        List<String> all = new ArrayList<>();
        all.addAll(one2);
        all.addAll(two2);
        //6. 根据姓名创建 Person 对象；
        List<Person> list = new ArrayList<>();
        for (String name : all) {
            list.add(new Person(name));
        }
        //7. 打印整个队伍的Person对象信息。
        for (Person person : list) {
            System.out.println(person);
        }
    }

    private static void demo_advance(List<String> one, List<String> two){

        Stream<String> streamOne = one.stream().filter(s -> s.length() == 3).limit(3);
        Stream<String> streamTwo = two.stream().filter(s -> s.startsWith("张")).skip(2);

        Stream.concat(streamOne, streamTwo).map(name-> new Person(name)).forEach(System.out::println);
        //Stream.concat(streamOne, streamTwo).map(Person::new).forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");

        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        demo_tradition(one,two);
        demo_advance(one,two);
    }

}
