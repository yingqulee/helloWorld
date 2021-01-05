package Base_JAVA.base_16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
    斗地主综合案例:有序
    1.准备牌
    2.洗牌
    3.发牌
    4.排序
    5.看牌
 */
public class demo_PokerGameSort {
    public static void main(String[] args) {
        //1.准备牌
        //创建一个Map集合,存储牌的索引和组装好的牌
        HashMap<Integer,String> poker = new HashMap<>();

        //创建一个List集合,存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();

        //创建两个String数组,存储牌的花色和牌的序号
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};

        //把大王小王存储到集合中
        //定义一个牌的索引
        int index = 0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;
        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;

        //增强for遍历两个集合,组装52张牌,存储到集合中
        for (String color : colors) {
            for (String number : numbers) {
                poker.put(index,color+number);
                pokerIndex.add(index);
                index++;
            }
        }
        /*System.out.println(pokerIndex);
        System.out.println(poker);*/
        //2.洗牌:Collections.shuffle(List);
        Collections.shuffle(pokerIndex);

        //3.发牌:定义4个集合
        ArrayList<Integer> play_01 = new ArrayList<>();
        ArrayList<Integer> play_02 = new ArrayList<>();
        ArrayList<Integer> play_03 = new ArrayList<>();
        ArrayList<Integer> bottom = new ArrayList<>();

        for (int i = 0; i < pokerIndex.size(); i++) {
            if (i < 3){
                bottom.add(pokerIndex.get(i));
            }else if (i % 3 == 0){
                play_01.add(pokerIndex.get(i));
            }else if (i % 3 == 1){
                play_02.add(pokerIndex.get(i));
            }else if (i % 3 == 2){
                play_03.add(pokerIndex.get(i));
            }
        }

        //4.排序: 默认是升序排序
        Collections.sort(play_01);
        Collections.sort(play_02);
        Collections.sort(play_03);
        Collections.sort(bottom);

        //5.看牌
        printPoker("吴彦祖",play_01,poker);
        printPoker("彭于晏",play_02,poker);
        printPoker("金城武",play_03,poker);
        printPoker("底牌",bottom,poker);

    }
    /*
        定义一个看牌的方法,提高代码复用性
        参数:
            String name : 玩家名称
            ArrayList<Integer> list : 存储玩家和底牌的List集合
            HashMap<Integer,String> poker : 存储牌的集合
        查表法:
            遍历玩家或者底牌的集合,获取牌的索引
            使用牌的索引,去Map集合中,找牌
     */
    private static void printPoker(String name,ArrayList<Integer> list,HashMap<Integer,String> poker) {
        System.out.print(name+":");
        //遍历玩家或者底牌集合,获取索引
        for (Integer key : list) {
            //根据索引,找到对应的value
            String value = poker.get(key);
            System.out.print(value+" ");
        }
        System.out.println();
    }
}
