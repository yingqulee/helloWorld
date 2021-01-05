package Base_JAVA.base_07;

import java.util.ArrayList;
import java.util.Random;

/*
发红包案例
 */
//群员
public class Member extends User{

    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> list){
        //从多个红包当中抽取一个
        //手气红包,随机获取一个集合当中的索引值
        int index = new Random().nextInt(list.size());
        //根据索引,从集合当中删除,并且得到被删除的红包,给自己
        int delta = list.remove(index);
        //当前群员自己本来有多少钱
        int money = super.getMoney();
        //加法,并且重新设置
        super.setMoney(money+delta);
    }
}
