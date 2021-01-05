package Base_JAVA.base_07;

/*
抽象方法:abstract关键字,去掉大括号,直接分号结束.
抽象类: 抽象方法所在的类,必是抽象类才行.在class之前写上abstract即可.
 */

public abstract class Animal {

    //这是一个抽象方法,代表吃东西,具体吃啥不确定.
    public abstract void eat();

    public abstract void sleep();
    //这是一个普通的成员方法
    /*public void NormalMethod(){

    }*/

}
