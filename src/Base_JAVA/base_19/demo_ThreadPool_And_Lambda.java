package Base_JAVA.base_19;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo_ThreadPool_And_Lambda {
    /*
       1.使用Lambda必须具有接口，且要求接口中有且仅有一个抽象方法。
          无论是JDK内置的 Runnable,Comparator 接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用Lambda。
       2.使用Lambda必须具有上下文推断。
          也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。
       备注:有且仅有一个抽象方法的接口，称为“函数式接口”。
     */

    public static void demo_ThreadPool(){
        /*
            与线程池相关的接口和类分别有：所有都在java.util.concurrent包当中。

            Executor是线程池的顶级接口，只负责执行任务。
            ExecutorService是子接口，也可以执行任务，额外还有线程池的管理功能。
            Executors是线程池相关的工具类，创建线程池就用这个类。

            使用线程池的基本步骤：
            1. 创建一个线程池，指定线程池的大小。
            2. 通过Runnable接口的run方法来指定任务内容。
            3. 将任务提交到线程池当中
            4. 可选地关闭线程池（也可以不关闭）

            线程分成两种：
            用户线程：只要没结束，程序就不会退出。【主要】
            守护线程：例如垃圾回收线程，只要所有的用户线程全都结束了，我自己也会结束。【次要】
            线程池创建出来默认里面都是用户线程，所以程序不会自己停止。
            如果希望关闭线程池，可以调用shutdown方法。如果关闭了线程池,就不能再submit,会抛异常
         */
        //1.创建一个线程池，指定线程池的大小。
        ExecutorService es = Executors.newFixedThreadPool(2);
        //3.将任务提交到线程池当中
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());

        es.shutdown();
    }

    public static void demo_Lambda(){
        /*
            lambda标准格式:
                a.一些参数
                b.一个箭头
                c.一段代码
            (参数列表) -> {一些重写方法的代码}
                小括号内的语法与传统方法参数列表一致：无参数则留空；多个参数则用逗号分隔。
                -> 是新引入的语法格式，代表指向动作。
                大括号内的语法与传统方法体要求基本一致。
         */
        //冗余的代码
        //1.使用匿名内部类实现多线程
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建了一个新的线程: "+Thread.currentThread().getName());
            }
        }).start();*/

        //2.使用lambda表达式,实现多线程
        new Thread(() ->
                System.out.println("创建了一个新的线程: " + Thread.currentThread().getName())
        ).start();

    }

    public static void demo_Practice_01(){
        //使用数组储存多个person对象
        Person[] arr = {
                new Person("吴彦祖",21),
                new Person("彭于晏",19),
                new Person("理迎趣",18)
        };

        //对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
        /*Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/

        //使用lambda表达式简化匿名内部类
        Arrays.sort(arr,(Person o1, Person o2)->{
            return o1.getAge() - o2.getAge();
        });

        for (Person person : arr) {
            System.out.println(person);
        }
    }

    public static void demo_Practice_02(int a, int b,Calculator c){
        int sum = c.calc(a,b);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        //demo_ThreadPool();
        //demo_Lambda();
        //demo_Practice_01();
        //使用lambda表达式练习有参数有返回值
        /*demo_Practice_02(10,5,(int a, int b)->{
            return a - b;
        });*/
        //优化
        //demo_Practice_02(10,5,(a, b)-> a + b);
    }
}
