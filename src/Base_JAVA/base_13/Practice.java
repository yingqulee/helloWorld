package Base_JAVA.base_13;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

public class Practice {

    public static void Year(){
        /*
        变量代表一个年份，int。
        判断是不是闰年，规则是：
        四年一闰，百年不闰，四百年再闰。

        牛逼哄哄吊炸天的Java 8全新日期/时间API：
        LocalDate
        LocalTime
        LocalDateTime
        Instant
        Duration
        Period

        Joda-Time的作者
         */
        int year = 2018;

        // yyyy年3月1日
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, 2);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        // 向前数一天
        cal.add(Calendar.DAY_OF_MONTH, -1);

        // 拿出来看看是28还是29
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(cal.getTime());
        System.out.println("是不是闰年：" + (day == 29));
        System.out.println("===========");

        LocalDate date = LocalDate.of(year, 1, 1);
        System.out.println(date);
        System.out.println(date.isLeapYear());
    }

    public static void StirngReverse(){
        /*
        字符串反转。

        顺序反转：ABCDA --> ADCBA
        排序反转：ABCDA --> AABCD --> DCBAA

        方案一：String --> toCharArray --> char[] --> 数组元素反转 --> char[] --> new String(char[])
        方案二：String --> "" + ... --> for循环倒序遍历 --> charAt(i)
        方案三：StringBuilder#reverse()，没有参数，所有内容直接反转。
         */
        //顺序反转
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String after1 = new StringBuilder(str1).reverse().toString();
        System.out.println(after1); // ZYXWVUTSRQPONMLKJIHGFEDCBA

        //排序反转
        String str2 = "ABCDA";
        char[] ch = str2.toCharArray();
        Arrays.sort(ch);
        String str3 = new String(ch);
        String after2 = new StringBuilder(str3).reverse().toString();
        System.out.println(after2);
    }

    public static void main(String[] args) {
        //StirngReverse();
        //Year();
    }
}
