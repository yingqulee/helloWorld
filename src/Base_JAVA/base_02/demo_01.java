package Base_JAVA.base_02;
/*面向对象三大特征: 封装,继承,多态*/
/*封装（英语：Encapsulation）是指一种将抽象性函式接口的实现细节部份包装、隐藏起来的方法。

封装可以被认为是一个保护屏障，防止该类的代码和数据被外部类定义的代码随机访问。

要访问该类的代码和数据，必须通过严格的接口控制。

封装最主要的功能在于我们能修改自己的实现代码，而不用修改那些调用我们代码的程序片段。

适当的封装可以让程式码更容易理解与维护，也加强了程式码的安全性。

封装的优点
1. 良好的封装能够减少耦合。

2. 类内部的结构可以自由修改。

3. 可以对成员变量进行更精确的控制。

4. 隐藏信息，实现细节。*/
public class demo_01 {
    //封装一个查最大值的方法
    /*public static int getMax(int a[]){
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }*/

    public static void main(String[] args) {
        //封装练习
        /*int a[] = {1,2,3,4,5,6,7,8,9,10};
        int max = getMax(a);
        System.out.println(max);*/

        /*User user = new User();
        user.setAge(10);
        user.setName("李狗嗨");
        user.setHeight(170);
        System.out.println(user.toString());*/

/*       //构造方法练习1
        Student student1 = new Student("李狗嗨",19);
        System.out.println(student1.toString());
        //构造方法练习2
        Student student2 = new Student();
        student2.setAge(19);
        student2.setName("嗨狗李");*/

        /*//匿名对象,只能唯一使用一次,使用建议:只是使用一次的话可以用匿名对象
        new Student().setName("矮方方");*/
    }
}
