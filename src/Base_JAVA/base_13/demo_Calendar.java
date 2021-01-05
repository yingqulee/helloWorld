package Base_JAVA.base_13;

import java.util.Calendar;
import java.util.Date;

/*
java.util.Calendar是一个抽象类，作用就是可以自动根据毫秒计算得到年月日、时分秒等各种信息，想用什么就拿什么。
这是一个抽象类，所以无法直接new对象。常用子类是（了解即可，不要背。）：GregorianCalendar。
注意：强烈建议不要自己new这个子类进行使用。（如果自己new了这个子类，必须自己进行非常复杂反人类的时间计算。）

推荐的、正确的、常用的Calendar获取方式，通过静态方法：
public static Calendar getInstance()：获取一个日历对象。

扩展一丢丢：
抽象类当中的静态方法的妙用：解耦合。随便换任何一个子类，对于使用的人（main方法）代码不用修改。
=================================================================================
Calendar里面常用的方法：

public int get(int field)：根据参数获取指定的数据项。
参数：你想要哪一条数据？想要年？想要月？想要……？
通过参数数组去记忆含义，不方便。推荐使用Calendar当中的常量。

public void set(int field, int value)：指定日历当中具体的数据项为自定义的取值。
参数field代表：你想改谁？年？月？日？……
参数value代表：你想改成多少？

public void add(int field, int amount)：堆日历当中指定的数据项，进行偏移量计算
偏移量计算就是在原有的基础上：向前减去多少，或者向后加上多少。
参数field代表：你想改谁？年？月？日？……
参数amount代表：你想偏移多少量？

public Date getTime()：将一个Calendar转换成为Date对象

注意事项：
1. Date类当中的getTime是得到long毫秒数
2. Calendar类当中的getTime是得到Date对象。
 */
public class demo_Calendar {

    public static void printCalendar(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String str = year + "年" + month + "月" + day + "日";
        System.out.println(str);
    }

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar);
        printCalendar(calendar);//输出此时此刻:2019年5月26日

        calendar.set(Calendar.YEAR, 2020);
        printCalendar(calendar);//2020年5月26日

        // 让天数向后数2天
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        printCalendar(calendar); //2020年5月28日

        // 让天数向前数3天
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        printCalendar(calendar); //2020年5月25日

        //Calendar类当中的getTime是得到Date对象
        Date date = calendar.getTime();
        System.out.println(date);//Mon May 25 17:10:39 CST 2020 || 2020年5月25日
    }
}
