package Base_JAVA.base_10;

/*
final关键字代表最终,不可改变.

常见四种用法:
1.可以修饰一个类
2.可以修饰一个方法
3.可以修饰一个局部变量 final int num = 100; 不可改变
4.可以修饰一个成员变量
 */
public class demo_01 {

    public static void main(String[] args) {
        /*Myclass myclass = new Myclass();
        myclass.method();*/

        //修饰一个局部变量
        final int num1 = 100;//正确写法

        final int num2;
        num2 = 200;//也是正确写法,保证有唯一一次赋值即可

        //对于基本类型来说,不可变说的是变量当中的数据不可变
        //对于引用类型来说,不可变说的是变量当中的地址值不可变
        /*Person person1 = new Person("赵丽颖");
        System.out.println(person1.getName());
        //两个person地址不一样
        person1 = new Person("胡歌");
        System.out.println(person1.getName());

        final Person person2 = new Person("刘亦菲");
        //person2 = new Person("刘一飞");错误写法!final的引用类型变量,其中的地址不可变
        System.out.println(person2.getName());//刘亦菲
        //但是内容可以改变
        person2.setName("小李飞刀");
        System.out.println(person2.getName());//小李飞刀*/
    }
}
