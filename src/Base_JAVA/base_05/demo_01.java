package Base_JAVA.base_05;
/*
静态static关键字概述:
如果一个成员变量一旦使用static关键字,那么这样的内容不再属于对象自己,
而是属于类的,所以凡是本类的对象,都共享同一份

无论是成员变量还是成员方法.如果有static,都推荐使用类名称进行调用
静态变量:类名称.静态变量;
静态方法:类名称.静态方法();

注意:
1.静态不行访问非静态;
原因: 因为内存当中是[先]有静态,[后]有的非静态内容.
2.静态方法当中不能用this
 */
public class demo_01 {
    public static void main(String[] args) {

        /*Student student1 = new Student("郭靖",19);
        student1.setRoom("乞丐班");
        System.out.println(student1.getName()+" "+student1.getAge()+" "+
                student1.getRoom()+" "+student1.getId());

        //谁学号在前面谁就是1号
        Student student2 = new Student("杨过",14);
        System.out.println(student2.getName()+" "+student2.getAge()+" "+
                student2.getRoom()+" "+student2.getId());*/

        //一旦使用static修饰成员方法,那么这就成为了静态方法,静态方法不属于对象,而是属于类的
        //如果没有static关键字,那么必须首先创建对象,然后通过对象才能使用它.

        /*StaticMethod staticMethod = new StaticMethod();//首先创建对象
        //然后使用它
        staticMethod.method();

        //对于静态方法来说,可以通过对象名进行调用,也可以直接通过类名称来调用.
        staticMethod.methodStatic();//不推荐,这种写法在编译之后也会被javac翻译成为"类名称.静态方法名"
        StaticMethod.methodStatic();//正确写法,推荐*/

        //静态代码块的练习
        //静态的内容比非静态优先
        /*Person person1 = new Person();//静态代码块执行一次,构造方法执行两次
        Person person2 = new Person();*/

    }

}
