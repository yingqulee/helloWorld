package Base_JAVA.base_06;
/*
 1,继承方法中的覆盖重写.
 2,继承关系中,父子类构造方法的访问特点.
 3.super的父类构造调用,必须是子类构造方法的第一个语句.(不能一个构造调用多次super构造)
总结:
子类必须调用父类构造方法,不写则赠送super();写了则用写的指定的super调用,super只能有一个,必须是第一个.

 super关键字的用法有三种:
 1.在子类的成员方法中,访问父类的成员变量. super.成员变量
 2.在子类的成员方法中,访问父类的成员方法. super.成员方法
 3.在子类的构造方法中,访问父类的构造方法. super.构造方法

 super用来访问父类内容,而this关键字用来访问本类内容.
 this关键字的用法有三种:
 1.在本类的成员方法中,访问本类的成员变量. this.成员变量
 2.在本类的成员方法中,访问本类另一个成员方法. this.成员方法
 3.在本类的构造方法中,访问本类另一个构造方法. this.构造方法
 第三种用法当中注意:
 A.this.(...)调用也必须是构造方法的第一个语句,也就是唯一一个
 B.super和this两种构造调用,不能同时使用.
 */

public class demo_02 {

    public static void main(String[] args) {
        /*Phone phone = new Phone();
        phone.call();
        phone.send();
        phone.show();

        NewPhone newPhone = new NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();*/

        //继承关系中,父子类构造方法的访问特点.
        //1,子类构造方法当中有一个默认隐含的"super()"调用,所以一定是先调用的父类
        //2.可以通过super关键字来子类构造调用父类重载构造
//        Son son = new Son();//先显示父类,再显示子类
    }
}
