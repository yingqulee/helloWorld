package Base_JAVA.base_13;

import java.util.Arrays;
import java.util.Date;

public class demo_System {
    public static void demo_01_System(){
        /*
        java.lang.System类是一个与系统相关的工具类，本身是final的，所以不能有子类，也就不能被覆盖重写。
        备注：System类的构造方法被私有化了，所以无法new对象，只能静态调用。

        两个常用的方法：
        public static long currentTimeMillis()：获取系统的当前毫秒数。
         */
        //System obj = new System(); // 错误写法！不能new对象！

        long time1 = System.currentTimeMillis();
        System.out.println(time1);//当前系统时间到1970-1-1 00:00:00 一共经历了多少毫秒

        long time2 = new Date().getTime();
        System.out.println(time2);//此时此刻毫秒数:1558862092570*/

        //测试程序的效率
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            System.out.println("Hello");
        }

        long end = System.currentTimeMillis();

        long time = end - start;
        System.out.println("耗时多少毫秒：" + time);
    }

    public static void demo_02_SystemArrayCopy(){
        /*
        System类当中提供了一个性能特别高的底层方法：
        public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        方法的作用：将老数组（源数组）当中的内容，复制到新数组（目标数组）中。

        第1个参数代表：源数组，也就是数据本来放在哪里
        第2个参数代表：源数组的起始索引，从几号索引开始复制(包括当前位置)
        第3个参数代表：目标数组，也就是数组将会被复制到哪里去
        第4个参数代表：目标数组的起始索引，从几号索引开始接收
        第5个参数代表：长度，也就是总共复制几个数据过去

        推荐使用：
        1. 不推荐使用for循环自己实现数组元素复制，因为写法复杂、性能低。
        2. 推荐使用System.arraycopy方法，因为性能贼高。
         */
        int[] arrayA = { 10, 20, 30, 40, 50 };//把20,30,40覆盖到数组B的后面3个
        int[] arrayB = { 1, 2, 3, 4, 5 };
        // 希望将arrayA中间三个元素，复制到arrayB的最后三个位置，成为：
        // { 1, 2, 20, 30, 40 }
        //将老数组（源数组）当中的内容，复制到新数组（目标数组）中。
        System.arraycopy(arrayA, 1, arrayB, 2, 3);
        System.out.println(Arrays.toString(arrayB));//[1, 2, 20, 30, 40]
    }

    public static void main(String[] args) {

    }
}
