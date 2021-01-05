package A_Others;

public class BitOperation {

    //对两个输入参数做加法运算，但是不能使用 “+” 运算符
    //先通过异或塞选出不用进位的情况，然后再用与运算和左移运算计算出进位的情况，迭代更新出最后的结果
    public static int plus(int a, int b) {
        int aTemp = 0, bTemp = 0;

        while (b != 0) {
            aTemp = a ^ b;
            bTemp = (a & b) << 1;
            a = aTemp;
            b = bTemp;
        }
        return a;
    }

    //不创建临时变量的情况下进行交换两个数
    public static void swap(int a, int b) {
        a ^= b; // a 中存放两数互异的点位
        b ^= a; // 取反 b 中不同于 a 的点位，也就是实现了 b = a
        a ^= b; // 取反 a 中不同于 b 的点位，也就是实现了 a = b

        System.out.println(a + " "+ b);
    }

    //把 A 转换成 B ，需要改变多少位?
    //两个数做异或的结果就是两个数差异所在，然后只需计算这个结果中有多少个 1 即可
    public static int convertA2B(int A, int B) {
        int n = A ^ B;
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // n - 1 是将 n 的最低位为零
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        /*int a = 3, b = 7;
        swap(a,b);
        System.out.println(convertA2B(a,b));
        System.out.println(plus(a,b));*/

        System.out.println("======================");
        int s = 8, k = 2, n = 2, t = 4, x = 5, y = 9;
        System.out.println("测试第 k 位: "+(s & (1 << k)));
        System.out.println("设置第 k 位: "+(s |= (1 << k)));
        System.out.println("第 k 位置零: "+(s &= ~(1 << k)));
        System.out.println("切换第 k 位值: "+(s ^= ~(1 << k)));
        System.out.println("乘以 2^n: "+(s << n));
        System.out.println("除以 2^n: "+(s >> n));
        System.out.println("交集: "+(s & t));
        System.out.println("并集: "+(s | t));
        System.out.println("减法: "+(s & ~t));
        System.out.println("交换: "+(x = x^y^(y=x)));
        System.out.println("得到最低位的 1 : "+(s & (-s)));
        System.out.println("清除最低位的 1 : "+(s & (s - 1)));
    }
}
