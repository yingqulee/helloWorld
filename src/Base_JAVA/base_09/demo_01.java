package Base_JAVA.base_09;
/*
    多态性: extends继承或implements实现,是多态的前提.一个对象拥有多种形态,就是对象的多态性
    代码当中体现多态性,其实就是一句话:父类引用指向子类的对象.
    格式:
    父类名称 对象名 = new 子类名称();
    接口名称 对象名 = new 实现类名称();
    ===========================================================
    访问成员变量的两种方式:
    1.直接通过对象名称访问成员变量:看等号左边是谁,优先用谁,没有则向上找
    2.间接通过成员方法访问成员变量:看该方法属于谁,优先用谁,没有则向上找
    ===========================================================
    在多态的代码当中,成员方法的访问规则是:
        看new的是谁,就优先用谁,没有则向上查找
        口诀:
        成员方法:编译看左边,运行看右边
        成员变量:编译看左边,运行还看左边
    ===========================================================
    对象的向上转型:其实就是多态写法;
    对象的向下转型:其实是一个还原动作---格式:子类名称 对象名 = (子类名称)父类对象
        注意:必须保证对象就是本来创建的,才能向下转型.
 */
public class demo_01 {

    public static void main(String[] args) {

        //使用多态写法
        //父类的引用,指向了子类的对象
        /*Father obj = new Son();
        obj.method();//子类方法
        obj.methodFather();//父类特有方法!*/

        //直接通过对象名称访问[成员变量]:看等号左边是谁,优先用谁
        /*Father obj = new Son();
        System.out.println(obj.num);//100 在father类
        //子类没有覆盖重写,就是父类的num
        //覆盖重写之后就是子类的num
        obj.showNumber();
        */

        //多态中成员方法的使用特点
        /*Father obj = new Son();
        //运行看右边,右边是Son,所以用的是son里面的method
        obj.method();//new的是子,用的是子方法
        obj.methodFather();//子类没有,用的是父类方法*/

        //编译看左边,左边是Father,当中没有methodSon方法,所有编译报错
        //obj.methodSon();//错误写法

        //对象的向上转型,一定是安全的;从小范围转到大范围
        /*Animals animals = new Cat();
        animals.eat();//吃鱼鱼*/

        //对象的向下转型
        //一旦向上转型为父类,那么就无法调用子类原本的特有方法
        //cat.catchMouse();//错误写法
        /*Cat cat = (Cat)animals;//向下转型,还原
        cat.catchMouse();*/

        //如何才能知道一个父类引用的对象,本来是什么子类?
        /*Animals animals = new Cat();//这是一只猫
        animals.eat();//吃鱼鱼*/
        //如果希望调用子类特有方法,需要向下转型---
        // 对象instanceof类名称 得要一个boolean值,判断对象能不能做后面类型的实例
        /*if (animals instanceof Dog){
            Dog dog = (Dog) animals;
            dog.watchHouse();
        }
        if (animals instanceof Cat){
            Cat cat = (Cat) animals;
            cat.catchMouse();
        }*/


    }
}
