package Base_JAVA.base_10;
/*

4.修饰一个成员变量
对于成员变量来说,如果使用final关键字修饰,那么这个变量也照样是不可变

1.由于成员变量具有默认值,所以用了final之后必须手动赋值,不再给默认值
2.对于final的成员变量,要么使用直接赋值,要么通过构造方法赋值.(二者选一)
3.必须保证类当中所有重载的构造方法,都最终会对final的成员变量进行赋值
 */
public class Person {

    //修饰一个成员变量
    //private final String name = "一条狗";一定要手动赋值

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
