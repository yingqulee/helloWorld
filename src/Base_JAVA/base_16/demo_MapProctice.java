package Base_JAVA.base_16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    题目要求：
    键盘输入一个字符串，然后统计其中每一个字符出现的次数。

    分析:
        1.使用Scanner获取用户输入的字符串
        2.创建Map集合,Key是字符串中的字符,value是字符的个数
        3.遍历字符串,获取每一个字符
        4.使用获取到的字符,在Map集合判断key是否存在
            key存在:
                通过字符(key),获取value(字符个数)
                value++
                put(k,v)把新的value存储到Map集合中
            key不存在:
                put(key,1)
        5.遍历Map集合,输出结果

    扩展一丢丢：
    getOrDefault方法两个参数：
    1. 第一个参数代表key
    2. 代表如果key不存在，取用的默认值
 */
public class demo_MapProctice {
    public static void main(String[] args) {
        //1.使用Scanner获取用户输入的字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();

        //2.创建Map集合,Key是字符串中的字符,value是字符的个数
        // key代表字符，value代表出现的次数
        Map<Character, Integer> map = new HashMap<>();

        //3.遍历字符串,获取每一个字符 使用增强for
        /*for (char c : str.toCharArray()) {
            //4.使用获取到的字符,在Map集合判断key是否存在
            if (map.containsKey(c)){
                //key存在
                Integer value = map.get(c);
                value++;
                map.put(c,value);
            }else{
                //key不存在
                map.put(c,1);
            }
        }*/

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // 当前单个字符
            int value = map.getOrDefault(ch, 0);
            map.put(ch, ++value);
      }
        System.out.println(map);
    }
}
