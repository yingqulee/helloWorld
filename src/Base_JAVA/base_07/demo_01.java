package Base_JAVA.base_07;

/*
抽象的概念:

如何使用抽象类和抽象方法:
1.不能直接创建new抽象类对象.
2.必须用一个子类来继承抽象父类.
3.子类必须[覆盖重写]抽象父类当中所有的抽象方法.
覆盖重写(实现):子类去掉抽象方法的abstract关键字,然后补上方法体的大括号
4.创建子类对象进行使用.

注意:
一个抽象类不一定含有抽象方法.
只要保证抽象方法所在的类是抽象类即可. 没有抽象方法的抽象类,也不能直接创建对象,在一些特殊场合有用途
 */

public class demo_01 {

    public static void main(String[] args) {

//        Animal animal = new Animal(); 不能直接创建抽象类,错误写法
        /*Cat cat = new Cat();
        cat.eat();//猫吃屁股*/

        /*Son son = new Son();
        son.eat();//父类->子类->吃屁屁!*/

//        Dog dog = new Dog();不能直接创建抽象类,错误写法

        /*DogHashiqi hashiqi = new DogHashiqi();//这是普通类,可以直接创建
        hashiqi.eat();
        hashiqi.sleep();

        DogAlashijia alashijia = new DogAlashijia();
        alashijia.eat();
        alashijia.sleep();*/
    }
}
