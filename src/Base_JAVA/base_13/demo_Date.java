package Base_JAVA.base_13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class demo_Date {
    public static void demo_01_Date(){
        /*
        java.util.Date类，用来表示一个“时间点”。
        计算机当中有一个原点时刻（Unix时间）：公元1970年1月1日0点0分0秒0毫秒
        一个Date对象内部就包含了一个很大的long数字，代表从原点时刻一直到程序运行的此时此刻，所经过的毫秒数。
        备注：这里的原点时刻，说的是格林尼治时间，也叫做格林威治。
        全中国统一使用北京时间，北京位于地理位置的东八区，所以对于我们来说，原点时刻是早上8点。

        构造方法：
        public Date()：无参数创建一个对象，代表程序运行的此时此刻。什么时候运行，我就代表什么时间。
        public Date(long time)：有参数，参数就是自定义指定的毫秒数。

        成员方法：
        public void setTime(long time)：设置毫秒数
        public long getTime()：获取毫秒数
         */
        Date date1 = new Date();
        System.out.println(date1);//此时此刻

        Date date2 = new Date(0L);
        System.out.println(date2);//Thu Jan 01 08:00:00 CST 1970

        Date date3 = new Date(1000000000L);
        System.out.println(date3);//Mon Jan 12 21:46:40 CST 1970

        long time = 1000000000L + (2 * 24 * 60 * 60 * 1000);
        date3.setTime(time);
        System.out.println(date3);//Wed Jan 14 21:46:40 CST 1970

        Date today = new Date(); // 此时此刻
        long millis = today.getTime();//获取毫秒数
        System.out.println(millis);
    }

    public static void demo_02_DateFormat() throws ParseException {
        /*
        java.text.DateFormat是一个抽象类，负责将String和Date来回转换。
        格式化：Date转换成为String，     public String format(Date date)：将参数日期时间转换成为返回值字符串
        解析：String转换成为Date         public Date parse(String str)：将参数字符串转换成为返回值日期时间

        这是一个抽象类，所以不能直接new对象。常用的子类是【java.text.SimpleDateFormat】
        如果Date类当中的toString格式不喜欢，那么就需要使用SimpleDateFormat来自己指定格式。

        构造方法：
        public SimpleDateFormat(String pattern)：参数就是我们想要的日期时间的格式。
        参数就是一个字符串，代表格式，只要记住一个就行：
        yyyy-MM-dd HH:mm:ss:SSS

        yyyy代表四位数字，年
        MM代表两位数字，月
        dd代表两位数字，日
        HH代表两位数字，时
        mm代表两位数字，分
        ss代表两位数字，秒
        SSS代表三位数字，毫秒
         */
        Date date = new Date();//此时此刻

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Date --> String，格式化
        String str = sdf.format(date);
        System.out.println(str);//此时此刻2019-05-26 16:33:20的String

        // String --> Date，解析
        String strTime = "2019-05-26 16:33:20";
        Date dateTime = sdf.parse(strTime);
        System.out.println(dateTime); //Sun May 26 16:33:20 CST 2019

        //String error = "adfasdfadsf";
        //Date d = sdf.parse(error);//ParseException
    }

    public static void demo_03_LifeDays() throws ParseException {
        /*
        题目要求：计算一下自己已经活了多少天。

        思路：
        1. 通过键盘输入告诉程序我的生日：Scanner next() --> String
        2. 将生日字符串，转换成为生日Date，String-->Date：SimpleDateFormat里面的parse方法。
        3. 根据生日Date对象，拿到毫秒数。
        4. 创建一个Date对象，无参数，代表此时此刻。
        5. 根据现在Date对象，拿到毫秒数。
        6. 用此时此刻的毫秒数，减去生日的毫秒数，得到差值。
        7. 将差值毫秒数换算成为天。
         */
        //1. 通过键盘输入告诉程序我的生日：Scanner next() --> String
        Scanner input = new Scanner(System.in);
        System.out.println("请输入生日：（格式为yyyy-MM-dd）");
        String birthday = input.next();

        //2. 将生日字符串，转换成为生日Date，String-->Date：SimpleDateFormat里面的parse方法。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = sdf.parse(birthday);

        //3. 根据生日Date对象，拿到毫秒数。
        long birthmillis = birthdate.getTime();

        //4. 创建一个Date对象，无参数，代表此时此刻。
        Date today = new Date();

        //5. 根据现在Date对象，拿到毫秒数。
        long todaymillis = today.getTime();

        //6. 用此时此刻的毫秒数，减去生日的毫秒数，得到差值。
        long delta = todaymillis - birthmillis;

        //7. 将差值毫秒数换算成为天。
        long days = delta / 1000 / 60 / 60 / 24;
        System.out.println("活了多少天：" + days);
    }

    public static void main(String[] args) throws ParseException {
        //demo_01_Date();
        //demo_02_DateFormat();
        //demo_03_LifeDays();
    }
}
