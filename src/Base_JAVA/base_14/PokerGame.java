package Base_JAVA.base_14;

import java.util.ArrayList;
import java.util.Collections;

/*
    斗地主综合案例:
    1:准备牌
    2:洗牌
    3:发牌
    4:看牌
 */
public class PokerGame {

    public static void main(String[] args) {
        //1:准备牌
        //定义一个存储54张牌的ArrayList集合,泛型使用String
        ArrayList<String> poker = new ArrayList<>();

        //定义两个String数组
        String[] colors = {"♠","♥","♣","♦",};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        //先把大王小王存储在poker中
        poker.add("大王");
        poker.add("小王");

        //循环遍历两个数组,组装52张牌
        for (String number:numbers) {
            for (String color : colors) {
                poker.add(color+number);
            }
        }

        //2:洗牌 使用集合的工具类Collections中的方法
        //static void shuffle(List<?> list) 使用默认的随机愿对指定列表进行置换
        Collections.shuffle(poker);

        //3:发牌
        //定义四个集合,存储玩家的牌和底牌
        ArrayList<String> play_1 = new ArrayList<>();
        ArrayList<String> play_2 = new ArrayList<>();
        ArrayList<String> play_3 = new ArrayList<>();
        ArrayList<String> bottom = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            if (i < 3){
                bottom.add(poker.get(i));
            }else if (i % 3 == 0){
                play_1.add(poker.get(i));
            }else if (i % 3 == 1){
                play_2.add(poker.get(i));
            }else if (i % 3 == 2){
                play_3.add(poker.get(i));
            }
        }

        //4:看牌
        System.out.println("刘德华"+play_1);
        System.out.println("周星驰"+play_2);
        System.out.println("周润发"+play_3);
        System.out.println("底牌"+bottom);
    }
}
