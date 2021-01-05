package Base_JAVA.base_06;
/*
面向对象的特性之一:继承性

一个类的直接父亲只能有唯一一个.
一个子类的直接父类是唯一的,但是父类可以拥有很多个子类.(可以多级继承)

特点:
1.子类可以拥有父类的内容;
2.子类还可以拥有之间专有的内容.

优点:代码复用
"子类就是一个父类"
extends关键字 父类名称

重写(Override)
概念:在继承关系当中,方法的名称一样,参数列表也一样
区别:
重写(Override):方法的名称一样,参数列表[也一样]; 覆盖重写,特点:创建的对象是谁,就优先用谁,如果没有就向上查找
重载(Overload):方法的名称一样,参数列表[不一样];

重写(Override)注意事项:
1.必须保证父子类之间方法的名称相同,参数列表也相同.
@Override:写在方法前面,用来检测是不是有效的正确覆盖重写.

2.子类方法的返回值必须<=父类方法的返回值范围
小扩展提示:Object类是所有类的公共最高父类, String是Object的子类

3.子类方法的权限必须>=父类方法的权限修饰符.
小扩展提示:public > protected > (default) > private
备注:(default)不是关键字default,而是什么都不写,留空

 */
public class demo_01 {

    public static void main(String[] args) {
       /* //创建一个子类对象
        Son son = new Son();
        son.FatherMethod();//继承父类的方法!*/


        /*Father father = new Father();
        System.out.println(father.Fathernum);//只能使用父类的东西,没有子类的内容

        Son son = new Son();
        System.out.println(son.Fathernum);//子类可以调用父类
        System.out.println(son.subnum);//子类可以调用自己*/

        //父类子类出现重名,访问规则:
        //直接访问:通过子类对象访问成员变量,等号左边是谁就优先用谁
        /*Son son = new Son();
        System.out.println(son.num);*/
        //间接访问:通过成员方法访问成员变量,方法属于谁就优先用谁,没有就向上找
        /*son.SonMethod();
        son.FatherMethod();*/

        //区分子类方法中的重名的三种变量
        /*Son son = new Son();
        son.SonMethod();//300 200 100*/

        //继承中成员方法的访问特点\
        //在父子类的继承关系当中,创建子类对象,访问成员方法
        //规则:创建的对象是谁,就优先用谁,如果没有就向上查找
        //注意事项:无论是成员方法还是成员变量,如果没有多事向上找父类,绝对不会向下找子类的
        /*Son son = new Son();//new的是一个子类 优先的就是子类对象
        son.FatherMethod();
        son.SonMethod();
        //优先的就是子类对象
        son.sameMethod();*/


    }
}
