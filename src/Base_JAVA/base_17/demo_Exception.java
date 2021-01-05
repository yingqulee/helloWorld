package Base_JAVA.base_17;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

/*
    java.lang.Throwable:类是Java语言中所有错误和异常的超类。
        Exception:编译期异常,进行编译(写代码)java程序出现的问题
            RuntimeException:运行期异常,java程序运行过程中出现的问题
                try{
                    //可能会出现异常的代码
                }
                catch{
                    //异常的处理逻辑
                }
            异常就相当于程序得了一个病,把异常处理掉,程序就可以继续执行
        Error:错误
            错误就相当于程序得了一个无法治愈的毛病.必须修改源代码,程序才能继续执行

    注意事项:
        如果父类抛出了多个异常,子类覆盖父类方法时,只能抛出相同的异常或者是他的子集。
        父类方法没有抛出异常，子类覆盖父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
 */
public class demo_Exception {
    /*
       throw关键字
       作用 : 可以使用throw关键字在指定的方法中抛出指定的异常
       使用格式 : throw new xxxException("异常产生的原因")
       注意:
           1.throw关键字必须写在方法的内部
           2.throw关键字后边的new的对象必须是Exception或者Exception的子类对象
           3.throw关键字抛出指定的异常对象,我们就必须处理这个异常对象
               throw关键字后边创建的是RuntimeException或者是RuntimeException的子类对象,我们可以不处理,默认交给JVM处理
               throw关键字后边创建的是编译异常,我们就必须处理这个异常,要么throws,要么try{}catch{}
    */
    private static int getNum(int[] array, int index) {
        /*
            throw:
            我们可以对传递过来的参数数组,进行合法性校验
            如果数组的值是null
            那么就抛出空指针异常.

            NullPointerException是一个运行期异常,我们可以不用处理,默认交给JVM
            ArrayIndexOutOfBoundsException是一个运行期异常,我们可以不用处理,默认交给JVM
         */
        if (array == null){
            throw new NullPointerException("你传的啥玩意?");
        }
        if (index < 0 || index > array.length){
            throw new ArrayIndexOutOfBoundsException("你越界咯");
        }
        return array[index];
    }

    public static void demo_ObjectsRequireNonNull(Object obj){
        /*
            Objects类中的静态方法
                public static <T> T requireNonNull(T obj) : 查看指定引用对象不是null。
            源码:
                public static <T> T requireNonNull(T obj) {     
                    if (obj == null)       
                        throw new NullPointerException();        
                return obj;
                }
         */
        /*if(obj == null)
            throw new NullPointerException("传的啥玩意?");*/
        //Objects.requireNonNull(obj);
        Objects.requireNonNull(obj,"传的啥玩意?");
    }

    //如果抛出的多个异常对象有子父类关系,那么直接声明父类的异常即可
    //FileNotFoundException extends IOException extends Exception
    public static void demo_Throws(String filename) throws IOException {
        /*
            throws关键字:异常处理的第一种方式,交给别人处理

            声明异常格式：修饰符 返回值类型 方法名(参数) throws 异常类名1,异常类名2…{   } 
            注意:
                1.throws关键字必须卸载方法声明处
                2.throws关键字后边声明的异常必须是Exception或者是Exception的子类
                3.方法内部如果抛出了多个异常对象,那么throws后边也声明多个异常
                    如果抛出的多个异常对象有子父类关系,那么直接声明父类的异常即可
                4.调用了一个声明抛出异常的方法,我们就必须的处理声明的异常
                    要么继续使用throws声明抛出,叫给方法的调用者处理,最终给JVM
                    要么try..catch自己处理异常
         */
        if (!filename.equals("c:\\a.txt")){
            //throw关键字后边创建的是编译异常,我们就必须处理这个异常,要么throws,要么try...catch
            //FileNotFoundException是编译异常,必须处理编译异常
            throw new FileNotFoundException("没有找到你说的文件");
        }
        /*
            如果传递的路径不是.txt结尾 抛出IO异常
         */
        if (!filename.endsWith(".txt")){
            throw new IOException("你忘写后缀了!");
        }
        System.out.println("路径没有问题!");
    }

    public static void demo_TryCatch(String filename) throws IOException{
        /*
            try..catch:异常处理的第二种方式,自己处理异常
            格式:
                try{
                        //可能会出现异常的代码
                    }
                    catch(定义一个异常的变量){
                        //异常的处理逻辑
                    }
                    ...(可以多个catch)
                    catch(异常类名 变量名){
                        //异常的处理逻辑
                    }
            注意:
                1.try中可能会抛出多个异常对象,那么久可以使用多个catch来处理这些异常
                2.如果try中产生了异常,那么就会执行catch中的异常处理逻辑,执行完catch中的处理逻辑,继续执行try..catch之后的代码
                    如果try中没有产生异常,那么不会执行catch中的异常处理逻辑,继续执行try..catch之后的代码
         */
        if(!filename.endsWith(".txt")){
            throw new IOException("你忘写后缀了!");
        }
    }

    public static void main(String[] args) throws IOException {

        int[] array = {15, 25, 35}; // [0] [1] [2]
        /*
            访问了数组中的10索引,而数组没有10索引,这时候JVM就会检测出程序出现异常
            JVM会做两件事:
                1.JVM会根据异常产生的原因创建一个异常对象,这个异常对象包含了异常产生的(内容,原因,位置)
                     new ArrayIndexOutOfBoundsException("10");
                2.在getNum方法中,没有异常的处理逻辑(try..catch),那么JVM就会把异常抛出给方法的调用者main方法来处理这个异常

                ----->main方法接受到了这个异常对象,main方法也有异常的处理逻辑,继续把对象抛出给main方法的调用者JVM处理
                ----->JVM接受到了这个异常对象
                                    1.把异常对象(内容,原因,位置)以红色的字体打印在控制台
                                    2.JVM会终止当前正在执行的java程序-->中断处理
         */
        //int result = getNum(array, 10);//ArrayIndexOutOfBoundsException: 10
        //System.out.println(result);

        //int[] arr = null;
        //int value = getNum(arr,0);//Exception in thread "main" java.lang.NullPointerException: 传递的数组的值是空

        //throws练习:调用了一个声明抛出异常的方法,我们就必须的处理声明的异常
        //demo_Throws("c//a");

        //try..catch练习
        try {
            //demo_TryCatch("c:\\a.tx");
            demo_TryCatch("c:\\a.tx");
        }catch(IOException e){//try中抛出什么,catch就定义什么异常变量
            System.out.println("抓到你了");
        /*
            Throwable 类中定义了3个异常处理的方法
                String getMessage() 返回throwable的简短描述
                String toString() 返回throwable的详细信息
                void printStackTrace() JVM打印异常对象,默认此方法,打印的异常信息是最全面的
         */
            //System.out.println(e.getMessage());//你忘写后缀了!
            //System.out.println(e.toString());//java.io.IOException: 你忘写后缀了!
            //System.out.println(e);

            e.printStackTrace();//最全面
        }finally {
            //无论是否出现异常都会执行
            System.out.println("资源释放放放放");
        }

        System.out.println("还是可以执行到最后的");

        /*
           finally:有一些特定的代码无论异常是否发生，都需要执行。另外，因为异常会引发程序跳转，导致有些语句执行不到。
                   而finally就是解决这个问题的，在ﬁnally代码块中存放的代码都是一定会被执行的。
            格式:
                try{
                        //可能会出现异常的代码
                    }
                    catch(定义一个异常的变量){
                        //异常的处理逻辑
                    }
                    ...(可以多个catch)
                    catch(异常类名 变量名){
                        //异常的处理逻辑
                    }finally{
                        无论是否出现异常都会执行
                    }
             注意:
                1.finally不能单独使用,必须和try一起使用
                2.finally一般用于资源释放(资源回收),无论程序是否出现异常,最后都要资源释放(IO)
                △如果ﬁnally有return语句,永远返回ﬁnally中的结果,避免该情况.
         */

    }
}
