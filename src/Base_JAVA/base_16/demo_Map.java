package Base_JAVA.base_16;

import java.util.*;

/*
    jva.util.Map<K,V>集合
    Map集合的特点:
        1.Map集合是一个双列集合,一个元素包含两个值<KEY,VALUE>
        2.Map集合中的元素,key和value的数据类型可以相同,可以不同
        3.Map集合中的元素,key是不允许重复的,value是可以重复的
        4.Map结合中的元素,key和value是一一对应的
    java.util.HashMap<k,v>集合 implements Map<K,V>接口
    HashMap集合的特点:
        1.HashMap集合底层是哈希表:查询速度非常快(数组+单向链表/红黑树)
        2.HashMap集合是一个无序的集合,存储元素和取出元素的顺序可能不一致
    java.util.LinkedHashMap<k,v>集合 extends HashMap<k,v>集合
    LinkedHashMap的特点:
        1.LinkedHashMap集合底层是哈希表+链表(保证迭代的顺序)
        2.LinkedHashMap集合是一个有序的集合,存储元素和取出元素的顺序是一致的
 */
public class demo_Map {

    public static void demo_01_Map(){
        /*
            public V put(K key, V value) :  把指定的键与指定的值添加到Map集合中。
            返回值 : v
                存储键值对的时候,key不重复,返回v是null
                存储键值对的时候,key重复,会使用新的value替换重复key的value值,返回被替换的value值
         */

        //创建Map集合,多态写法
        //Map<String,String> map1 =  new HashMap<>();

        /*String v1 = map1.put("盖伦","卡特");
        System.out.println(v1);//key不重复,返回v是null
        String v2 = map1.put("盖伦","光辉");
        System.out.println(v2);//返回被替换的value值:卡特
        System.out.println(map1);//{盖伦=光辉}*/

        /*map1.put("盖伦","光辉");
        map1.put("蛮王","艾希");
        map1.put("德邦","光辉");
        System.out.println(map1);//{德邦=光辉, 蛮王=艾希, 盖伦=光辉}*/

        /*
            public V remove(Object key) : 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值
            返回值:v
                key存在,v返回被删除的值
                key不存在,v返回null
         */
        Map<String,Integer> map2 =  new HashMap<>();
        map2.put("林黛玉",168);
        map2.put("晴雯",168);
        map2.put("史湘玉",165);
        System.out.println(map2);

        Integer v1 = map2.remove("林黛玉");
        System.out.println(v1);//168
        //int v2 = map2.remove("林黛鱼");//自动拆箱 NullPointerException 尽量使用包装类Integer
        Integer v2 = map2.remove("林黛鱼");
        System.out.println(v2);//null

        /*
            public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
            返回值:v
                key存在,v返回被删除的值
                key不存在,v返回null
         */
        Integer v3 = map2.get("晴雯");
        System.out.println(v3);//168
        Integer v4 = map2.get("屎湘玉");
        System.out.println(v4);//null

        /*
            boolean containsKey(Object key) 判断集合中是否包含指定的键
            返回值:    包含返回true 不包含返回false
         */
        boolean b1 = map2.containsKey("晴雯");
        System.out.println(b1);//true
        boolean b2 = map2.containsKey("雨雯");
        System.out.println(b2);//false
    }

    public static void demo_02_KeySet(){
        /*
            Map集合的第一种遍历方式:通过键找值的方式
            Map集合中的方法:
                Set<K> KeySet() 返回此映射中包含的键的Set视图
            实现步骤:
                1.使用Map集合中的方法keySet(),把Map集合所有的key取出来,存储到一个Set集合中
                2.遍历set集合,获取Map集合中的每一个key
                3.通过Map集合中的方法get(key),通过key找到value
         */
        Map<String,Integer> map = new HashMap<>();
        map.put("抱琴",17);
        map.put("司棋",18);
        map.put("侍书",19);
        map.put("入画",20);

        //1.使用Map集合中的方法keySet(),把Map集合所有的key取出来,存储到一个Set集合中
        Set<String> keySet = map.keySet();

        //2.遍历set集合,获取Map集合中的每一个key
        //使用迭代器
        /*Iterator<String> it = keySet.iterator();
        while(it.hasNext()){
            String key = it.next();
            //3.通过Map集合中的方法get(key),通过key找到value
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }*/
        //使用增强for
        for (String key : keySet) {
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
    }

    public static void demo_03_EntrySet(){
        /*
            Map集合遍历的第二种方式: 使用Entry对象遍历

            Map集合中的方法:
                Set<Map.Entry<K,V>> entrySet() 返回此映射中包含的映射关系的Set视图
            使用步骤:
                1.使用Map集合中的方法entrySet(),把Map集合中多个Entry对象取出来,存储到一个Set集合中
                2.遍历Set集合,获取每一个Entry对象
                3.使用Entry对象中的方法getKey()和getValue()获取键与值
         */
        Map<String,Integer> map = new HashMap<>();
        map.put("抱琴",17);
        map.put("司棋",18);
        map.put("侍书",19);
        map.put("入画",20);

        //1.使用Map集合中的方法entrySet(),把Map集合中多个Entry对象取出来,存储到一个Set集合中
        Set<Map.Entry<String,Integer>> set = map.entrySet();

        //2.遍历Set集合,获取每一个Entry对象
        //使用迭代器
        /*Iterator<Map.Entry<String, Integer>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            //3.使用Entry对象中的方法getKey()和getValue()获取键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+" : "+value);
        }*/
        //使用增强for
        for (Map.Entry<String, Integer> entry : set) {
            //3.使用Entry对象中的方法getKey()和getValue()获取键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+" : "+value);
        }
    }

    public static void demo_04_HashMapSavePerson(){
        /*
            HashMap存储自定义类型键值
            Map集合保证key是唯一的:
                作为key的元素,必须重写hashcode方法和equals方法,保证key唯一

            key:String类型
                String类重写hashcode方法和equals方法,可以保证唯一
            value:Person类型
                value可以重复
         */
        //Person为value
        /*HashMap<String,Person> map = new HashMap<>();

        map.put("广州",new Person("吴彦祖",21));
        map.put("茂名",new Person("古巨基",20));
        map.put("水东",new Person("彭于晏",22));
        map.put("沙琅",new Person("周星驰",23));
        map.put("广州",new Person("金城武",20));
        
        //keySet+增强for
        Set<String> set = map.keySet();
        for (String key : set) {
            Person value = map.get(key);
            System.out.println(key+"--->"+value);//键值不允许重复 金城武覆盖了吴彦祖
        }*/

        //Person为Key
        HashMap<Person,String> map = new HashMap<>();
        map.put(new Person("无颜卒",10),"广州");
        map.put(new Person("银败文",17),"香港");
        map.put(new Person("烹鱼宴",20),"澳门");
        map.put(new Person("古巨鸡",30),"珠海");
        map.put(new Person("无颜卒",10),"佛山");
        //使用entrySet+增强for
        Set<Map.Entry<Person, String>> entrySet = map.entrySet();
        for (Map.Entry<Person, String> entry : entrySet) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"--->"+value);
        }
    }

    public static void demo_05_LinkedHashMap(){
        /*
            java.util.LinkedHashMap<K,V> extends HashMap<K,Y>
            Map 接口的哈希表和连接列表实现,具有可预知的迭代顺序.
            底层原理:
                哈希表+链表(记录元素的顺序)
         */
        LinkedHashMap<String,String> linked = new LinkedHashMap<>();
        linked.put("a","a");
        linked.put("c","c");
        linked.put("b","b");
        linked.put("e","e");
        linked.put("d","d");
        linked.put("a","a");
        System.out.println(linked);//key不允许重复 且有序

    }

    public static void demo_06_HashTable(){
        /*
            java.util.HashTable<K,V>集合 implements Map<K,V>接口

            HashTable:底层也是一个哈希表,是一个线程安全的集合,是单线程集合,速度慢
            HashMap:底层是一个哈希表,是一个线程不安全的集合,是多线程的集合,速度快

            HashTable集合,不能存储NUll值,null键
            HashMap集合(之前学的所有集合):可以存储null值和null键

            HashTable和Vector集合一样,在jdk1.2版本之后被先进的集合(HashMap,ArrayList)取代了
            HashTable的子类Properties依然还活跃
            Properties集合是一个唯一和IO流相结合的集合
         */
        HashMap<String,String> map = new HashMap<>();
        map.put(null,"a");
        map.put(null,null);
        map.put("b",null);
        System.out.println(map);//{null=null, b=null} 允许存储空值空键

        Hashtable<String,String> table = new Hashtable<>();
        table.put(null,null);
        System.out.println(table);//NullPointerException 不允许存储空值空键

    }

    public static void main(String[] args) {
        //demo_01_Map();
        //demo_02_KeySet();
        //demo_03_EntrySet();
        //demo_04_HashMapSavePerson();
        //demo_05_LinkedHashMap();
        //demo_06_HashTable();
    }
}
