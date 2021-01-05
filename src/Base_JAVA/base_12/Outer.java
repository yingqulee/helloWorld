package Base_JAVA.base_12;

/*
  1.如果出现重名现象,那么格式:外部类名称.this.外部类成员变量名
  ======================================================
  2.如果以个类是定义在意个方法内部的,那么这就是一个局部内部类.
  "局部":只有当前所属的方法才能使用它,出了这个方法外面就不能用了.
  小结: 定义一个类的时候,权限修饰符规则:
  a.外部类: public / (default)
  b.内部类: public / protected / (default) / private
  c.局部内部类: 什么都不能写 不是(default)
  ======================================================
  3.如果希望访问所在方法的局部变量,那么这个局部变量必须是[有效final的]
  备注:从java 8+开始,只要局部变量事实不变,那么final关键字可以省略
  a.new出来的对象在堆内存当中
  b.局部变量是跟着方法定的,在栈内存当中
  c.方法运行结束之后,立即出栈,局部变量就会立即消失
  d.但是new出的对象会在堆当中持续存在,直到垃圾回收消失
  ======================================================
 */
public class Outer {

    /*int n = 100;//外部类的成员变量

    public class Inner{

        int n = 200;//内部类的成员变量

        public void methodInner(){

            int n = 300;//局部变量
            System.out.println(n);//局部变量
            System.out.println(this.n);//内部类的成员变量
            System.out.println(Outer.this.n);//外部类的成员变量
        }
    }*/

    /*//局部内部类练习
    public void methodOuter(){

        class Inner{//"局部内部类"
            int num = 100;
            public void methodInner(){
                System.out.println(num);//100
            }
        }
        //只有当前所属的方法才能使用它,出了这个方法外面就不能用了.
        Inner inner = new Inner();//如果没有创建局部内部类对象调用局部内部类方法,那么外部类无法访问局部内部类内容
        inner.methodInner();

    }*/

    //访问所在方法的局部变量,那么这个局部变量必须是[有效final的]
    /*public void methodFinal(){//外部类方法

        //从java 8+开始,只要局部变量事实不变,那么final关键字可以省略
        *//*final*//* int num = 100;//外部类方法局部变量

        class Inner{//局部内部类
            public void methodInnerFinal(){
                System.out.println(num);
            }
        }
    }*/
}
