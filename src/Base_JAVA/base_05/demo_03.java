package Base_JAVA.base_05;
/*
java.lang.Math
Math.abs();获取绝对值,
Math.ceil();向上取整,
Math.floor();向下取整,
Math.round();四舍五入,

Math.PI;π值
 */
public class demo_03 {

    public static void main(String[] args) {
        /*//Math.abs();获取绝对值
        System.out.println(Math.abs(3.18));//3.18
        System.out.println(Math.abs(0));//0
        System.out.println(Math.abs(-5));//5

        //Math.ceil();向上取整
        System.out.println(Math.ceil(3.9));//4.0
        System.out.println(Math.ceil(3.5));//4.0
        System.out.println(Math.ceil(3.0));//3.0

        //Math.floor();向下取整
        System.out.println(Math.floor(3.8));//3.0
        System.out.println(Math.floor(3.1));//3.0
        System.out.println(Math.floor(3.9));//3.0

        //Math.round();四舍五入
        System.out.println(Math.round(2.4));//2
        System.out.println(Math.round(2.5));//3*/

        //Math的练习;
        // 计算-10.8到5.9之间,绝对值大于6和小于2.1的整数有多少?
        /*double min = -10.8;
        double max = 5.9;
        //变量i就是区间之内所有的整数
        for (int i = (int)min; i < max; i++){
            int abs = Math.abs(i);//绝对值
            if (abs > 6 || abs < 2.1){
                System.out.print(i + " ");
            }
        }*/
    }
}
