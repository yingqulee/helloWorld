package Base_JAVA.base_20;

import java.io.File;
import java.io.IOException;

/*
    程序当中使用java.io.File类来代表一个文件或者文件夹。可以支持跨平台：

    Windows当中表示文件路径：    D:\abc\Hello.txt
    macOS/Linux当中表示路径：    /Users/someone/abc/Hello.txt

    File对象可以代表文件，也可以代表文件夹。
    表示文件：D:\abc\Hello.txt
    表示文件夹：D:\abc

    注意：绝对不能根据名称来判断是文件还是文件夹。

    File类的构造方法：
    public File(String pathname)：参数代表文件或者文件夹的路径。
    public File(String parent, String child)：第一个参数代表父文件夹，第二个参数代表其中的子文件夹或者文件。
    public File(File parent, String child)：第一个File对象代表父文件夹，第二个参数代表其中的子文件夹或者文件。

    备注：在双引号当中如果希望表示一个反斜杠，必须双写：\\
    注意：创建File的时候，只要路径是格式正确即可，不要求对应的文件或者文件夹是否真实存在。
    ===========================================================================
    绝对路径：从Windows的盘符开始，一致到具体的文件或文件夹名称，完整的路径。
    例如：D:\IdeaProjects\advance59\day08-code\story.txt

    相对路径：相对于当前项目而言（不是模块），一个简短的路径。
    例如：day08-code\story.txt

    TIPS：
    不一定项目外面就用绝对路径，也不一定项目里面就用相对路径。
    项目里面的东西，也可以使用绝对路径。
    项目外面的东西，也可以使用相对路径。
    如果使用相对路径，希望表示上一级，就可以：“../../../abc.txt”

    abc.txt
    day08-code\text.txt
    D:\abc.txt
 */
public class demo_File {

    public static void demo_01(){
        //public File(String pathname)：参数代表文件或者文件夹的路径。
        File f1 = new File("E:\\综合课程设计\\test\\test.txt");
        System.out.println(f1);//只要路径是格式正确即可，不要求对应的文件或者文件夹是否真实存在。
    }

    public static void demo_02(String parent, String child){
        //public File(String parent, String child)：第一个参数代表父文件夹，第二个参数代表其中的子文件夹或者文件。
        File f2 = new File(parent,child);
        System.out.println(f2);
    }

    public static void demo_03(){
        //public File(File parent, String child)：第一个File对象代表父文件夹，第二个参数代表其中的子文件夹或者文件。
        File parent = new File("e:\\");
        File file = new File(parent,"test.txt");//可以对parent进行操作使用很多方法
        System.out.println(file);
    }

    private static void demo_04() {
        /*
            与获取相关的方法有：

            public String getAbsolutePath()：获取绝对路径（从盘符开始，一直到具体的文件/文件夹名称位置，完整路径）。
            public String getPath()：获取“构造参数路径”（new的时候什么路径，现在得到就是什么路径。）
            public String getName()：获取文件的简短名称（只有单级文件/文件夹的名字，不包含父文件夹）
            public long length()：获取文件的大小，也就是其中的字节数。
         */

        File file1 = new File("D:\\abc\\IT书籍\\人月神话.txt");

        // 一定是获取绝对路径，就算new的时候不是绝对，也照样转换成为绝对路径
        System.out.println("绝对路径：" + file1.getAbsolutePath()); // D:\abc\IT书籍\人月神话.txt

        // new的时候参数什么样子，我就是什么样子。如果参数不是绝对路径，那么我也不是绝对路径
        System.out.println("构造方法的参数路径：" + file1.getPath()); // D:\abc\IT书籍\人月神话.txt

        // 获取不含有位置路径信息的简短文件名称
        System.out.println("简短名称：" + file1.getName()); // 人月神话.txt

        // 获取文件的长度，也就是字节数,文件夹没有大小,不能获取文件夹的大小,一定返回0
        System.out.println("大小：" + file1.length()); // 5
    }

    private static void demo_05() {
        /*
            与判断相关的常用方法有：

            public boolean exists()：判断文件或文件夹是否存在。
            public boolean isFile()：判断这是一个文件。
            public boolean isDirectory()：判断这是一个文件夹。

            既然new File对象的时候，无所谓是否真的存在。那么判断存在就用exists方法。
            既然文件和文件夹都可以使用File对象表示，那么判断到底是个啥，就用isFile或者isDirectory方法。

            注意：
            1. 对象创建出来，并不代表文件就一定存在。必须使用exists()方法判断。
            2. 绝对不能根据文件名称来判断是不是文件，或是不是文件夹。必须使用isFile()、isDirectory()方法判断。
         */
        File file1 = new File("E:\\综合课程设计\\a.txt");
        System.out.println("是否存在：" + file1.exists());

        File file2 = new File("a.txt");
        System.out.println("是否存在：" + file2.exists());

        File file3 = new File("E:\\综合课程设计\\a.txt");
        System.out.println("是不是文件：" + file3.isFile());
        System.out.println("是不是文件夹：" + file3.isDirectory());

        File file4 = new File("E:\\综合课程设计");
        System.out.println("是不是文件：" + file4.isFile());
        System.out.println("是不是文件夹：" + file4.isDirectory());
    }

    private static void demo_06() throws IOException {
        /*
            与创建相关的方法：

            public boolean createNewFile()：创建对应的文件，返回创建是否成功。（如果文件已经存在，就会不成功。）
            public boolean delete(): 删除由此File表示的文件或目录
            public boolean mkdir()：创建对应的【单级】文件夹，返回创建是否成功。
            public boolean mkdirs()：创建对应的【多级】文件夹，返回创建是否成功。

            注意事项：
            1. 通过代码删除的东西，真的是删除，不会进入回收站（或者废纸篓），所以必须谨慎操作。
            2. 如果删除文件夹，必须保证文件夹是空的，才能删除。
            意味着：如果删除的文件夹不是空的，真的要删除，就必须一层一层先把里面的内容删除掉，才能删除外面这一层文件夹。
         */
        File file1 = new File("E:\\综合课程设计\\JavaBook.txt");
        System.out.println("JavaBook.txt是否存在：" + file1.exists()); // true
        System.out.println("创建是否成功：" + file1.createNewFile()); // false
        System.out.println("JavaBook.txt是否存在：" + file1.exists()); // true

        // 路径中间有的文件夹不存在，那么就无法创建后面的文件。
        //File file2 = new File("E:\\综合课程设计\\abc\\data.txt");
        //file2.createNewFile(); // 异常，因为中间有的文件夹不存在

        // 这是即将创建一个单级文件夹，也就是只有最后一段是需要创建的文件夹，
        // 而其中的E:\综合课程设计 是已经存在的。
        File file3 = new File("E:\\综合课程设计\\测试文件夹");
        System.out.println("创建测试文件夹是否成功：" + file3.mkdir());

        // 这是即将创建多级文件夹，因为最后的两段JVM和“小脑斧”全都不存在。
        // 如果使用mkdir无法创建，如果使用mkdirs就可以连带创建。
        File file4 = new File("D:\\abc\\JVM\\小脑斧");
        //System.out.println("创建JVM\\小脑斧是否成功：" + file4.mkdirs());
        System.out.println("删除JVM\\小脑斧是否成功：" + file4.delete());
    }

    private static void demo_07(){
        /*
        与列出内容相关的方法：
        public String[] list()：列出当前文件夹下面所有内容的“简短名称字符串”们。
        public File[] listFiles()：列出当前文件夹下面所有内容的“文件对象”们。

        隐藏文件和隐藏文件夹都可以打印出来
         */
        File dir = new File("E:\\综合课程设计"); // 这是一个文件夹，我要查看其中的内容。

        String[] names = dir.list();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("===========");

        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        //demo_01();
        //demo_02("c:\\","test.txt");//灵活多变
        //demo_02("d:\\","test.txt");
        //demo_03();
        //demo_04();
        //demo_05();
        /*try {
            demo_06();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //demo_07();
    }

}
