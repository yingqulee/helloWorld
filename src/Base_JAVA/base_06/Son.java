package Base_JAVA.base_06;

//定义一个子类
public class Son extends Father {

    /*int subnum = 20;

    int num = 200;

    public void SonMethod(){
       System.out.println("子类方法执行啦!");
        //本类当中有num,优先用过自己的
//        System.out.println(num);

        //2.区分子类方法中重名的三种变量
        *//* 局部变量: 直接写成员变量名
         * 本类的成员变量: this.成员变量名
         * 父类的成员变量: super.成员变量名*//*
        *//*int num = 300;
        System.out.println(num);//300,局部变量
        System.out.println(this.num);//200,本类的成员变量
        System.out.println(super.num);//100,父类的成员变量*//*
    }

    public void sameMethod(){
        System.out.println("子类重名方法执行!");
    }

    @Override
    public void method(){

    }*/

    public  Son(){

        //super();//在调用父类无参构造方法

        //可以通过super关键字来子类构造调用父类重载构造
        //super();只能有一个super调用
        /*super(20);//在调用父类重载的构造方法
        System.out.println("子类构造方法执行");*/

//        this(123);//本类的无参构造,调用本类的有参构造 只能有一个this
    }

   /*public void method(){
        //super(); 错误写法!只有子类构造方法才可以调用父类构造方法
    }*/

   public Son(int n){

   }

}
