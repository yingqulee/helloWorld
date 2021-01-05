package Base_JAVA.base_20;

import java.io.File;

/*
    方法的递归调用，就是方法的一种特殊调用格式而已：方法自己调用自己。

    直接递归：a调用a。
    间接递归：a调用b，b调用c，c调用a。

    使用方法的递归调用，来计算1~n之和。

    如果n==3的话，那么3 + 2 + 1
    如果n==4的话，那么4 + 3 + 2 + 1

    递归调用必须设置终止条件，否则将会出现无限递归下去（死递归），将会发生错误：
    栈溢出错误 StackOverflowError
    构造方法禁止递归
 */
public class demo_Recursion {

    public static int demo_01(int n){
        if (n == 1){
            return 1;
        }
        return n + demo_01(n - 1);
    }

    public static int demo_02(int n){
        if (n == 1){
            return 1;
        }
        return n * demo_02(n - 1);
    }

    public static void demo_03(File dir){
        File[] files = dir.listFiles();
        for (File f : files) {
            System.out.println(f);
            if (f.isDirectory()){
                demo_03(f);
            }
        }
    }

    public static void demo_04(File dir){
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                demo_04(f);
            }else {
                String path = f.getPath().toLowerCase();
                //调用String类中的方法endsWith判断字符串是否是以xxx结尾
                if (path.endsWith(".java")) System.out.println(f);
            }
        }
    }

    public static void demo_05_FileFilter(File dir){
        //使用文件过滤器,需要自己重写accept方法增加判断
        /*File[] files1 = dir.listFiles(new FileFilterImpl());
        for (File f : files1) {
            if (f.isDirectory()){
                demo_05_FileFilter(f);
            }else {System.out.println(f);}
        }*/

        //使用文件过滤器+匿名内部类,需要自己重写accept方法增加判断...
        /*File[] files2 = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".java");
            }
        });
        for (File f : files2) {
            if (f.isDirectory()){
                demo_05_FileFilter(f);
            }else {System.out.println(f);}
        }*/

        //FilenameFilter() 和 FileFilter() 接口中都只有一个抽象方法,那么可以使用lambda表达式
        //File[] files3 = dir.listFiles((pathname)-> pathname.isDirectory() || pathname.getPath().toLowerCase().endsWith(".java"));
        File[] files3 = dir.listFiles((File dir2, String name)->  new File(dir2,name).isDirectory() || name.toLowerCase().endsWith(".java"));
        for (File f : files3) {
            if (f.isDirectory()){
                demo_05_FileFilter(f);
            }else {System.out.println(f);}
        }
    }

    public static void main(String[] args) {
        //System.out.println(demo_01(100));
        //System.out.println(demo_02(3));

        File file = new File("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day08-code\\src\\cn\\itcast\\day08");
        //demo_03(file);
        //demo_04(file);
        demo_05_FileFilter(file);
    }
}
