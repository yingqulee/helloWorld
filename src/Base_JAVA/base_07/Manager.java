package Base_JAVA.base_07;

/*
发红包案例
 */
//群主
import java.util.ArrayList;

public class Manager extends User{

    public Manager(){
        //super();默认
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney, int count){
        //首先需要一个集合,用来存储若干个红包的金额
        ArrayList<Integer> redList = new ArrayList<>();
        
        //首先看看群主有多少钱;
        int pocketMoney = super.getMoney();
        if (totalMoney > pocketMoney){
            System.out.println("余额不足!");
            return redList;//返回空集合
        }
        //扣钱,重新设置余额
        super.setMoney(pocketMoney-totalMoney);
        
        //发红包发多少份?
        int avg = totalMoney / count;
        int mod = totalMoney % count; //余数,剩下的零头

        //除不开的零头,包在最后一个红包当中
        //把红包一个一个放到余额当中
        for (int i = 0; i < count; i++) {
            redList.add(avg);
        }

        //最后一个红包
        int last = avg + mod ;
        redList.add(last);

        return redList;
    }
}
