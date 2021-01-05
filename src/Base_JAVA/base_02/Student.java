package Base_JAVA.base_02;
//构造方法
/*
注意事项!
1.构造方法的名称必须和所在的类名一致,大小写也一样
2.构造方法不要写返回值类型,void也不要
3.构造方法不能return一个具体的返回值
4.如果没有编写任何构造方法,那么编译器会默认赠送一个,没有参数,方法体,什么事情都不做
public Student(){}
5.一旦编写了至少一个构造方法,那么编译器将不会再赠送
6.构造方法可以进行重载.(重载:方法名相同,参数不同)
 */
//标准的类
/*
一个标准的类通常要拥有四个组成部分;
1.所有的成员变量都要使用private关键字修饰
2.为每一个成员变量编写一对Getter/Setter方法
3.编写一个无参数的构造方法
4.编写一个全参数的构造方法

这样的标准的类也叫做JAVA Bean
 */

public class Student {

    private String name;
    private int age;

/*    //无参数的构造方法 Construtor 选择 无
    public Student(){
        System.out.println("无参数构造方法!");
    }

    //全参数的构造方法 Construtor 选择 全部
    public Student(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("有参数构造方法!");
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
