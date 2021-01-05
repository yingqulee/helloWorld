package Base_JAVA.base_25;

import java.util.*;
import java.util.stream.Stream;

// java.util.Collection 接口中加入了default方法 stream 用来获取流，所以其所有实现类均可获取流
public class demo_CollectionStream {
    public static void main(String[] args) {
        //把集合转换为Stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        /*
            java.util.Map 接口不是 Collection 的子接口，且其K-V数据结构不符合流元素的单一特征，
            所以获取对应的流需要分key、value或entry等情况：
         */
        Map<String, String> map = new HashMap<>();
        //获取键,存到一个Set集合中
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();
        //获取值,存到一个Collection集合中
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();
        //获取键值对
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();

        //把数组转换为Stream  count和foreach都是终结方法,调用之后就不能再调用了
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5, 6);
        //stream6.map(i-> i+"").forEach(name-> System.out.println(name));
        long count = stream6.count();
        System.out.println(count);
        //可变参数可以传递数组
        String[] array = { "张无忌", "张翠山", "张三丰", "张一元" };
        Stream<String> stream7 = Stream.of(array);
        stream7.skip(3).forEach(name-> System.out.println(name));
        //stream7.forEach(name-> System.out.println(name));
        //Stream<String> stream8 = stream7.limit(3);//limit方法是一个延迟方法,返回的是一个新的流
        //stream8.forEach(name-> System.out.println(name));

        Stream<String> streamA = Stream.of("美羊羊", "喜洋洋", "红太狼", "小灰灰");
        Stream<String> streamB = Stream.of("晴雯", "宝玉", "宝钗", "湘玉");
        Stream.concat(streamA,streamB).forEach(name-> System.out.println(name));
    }
}
