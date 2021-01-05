package Base_JAVA.base_04;

/*
String.
1.字符串是常量，它们的值不能被创建后改变。
2.支持可变字符串字符串缓冲区。
3.因为字符串对象是不可改变的(重点)，所以它们可以被共享。
4.相当于char[]字符数组,但是底层原理是byte[]字节数组.

创建字符串的常见3+1种方式.
三种构造方法:
public String():创建一个空白字符串,不含有任何内容
public String(char[] array):根据字符数组的内容,来创建对应的字符串.
public String(byte[] array):根据字节数组的内容,来创建对应的字符串.

一种直接创建:
String str = "shabi";
 */
public class demo_01 {
    //Stirng练习
    public static void main(String[] args) {
        /*String基础内容:
        //使用空参构造
        String str1 = new String();
        System.out.println(str1);//空字符串

        //根据字符数组的内容,来创建对应的字符串.
        char[] charArray = {'A','B','C'};
        String str2 = new String(charArray);
        System.out.println(str2);//ABC

        //根据字节数组的内容,来创建对应的字符串.
        byte[] byteArray = {97, 98 ,99};
        String str3 = new String(byteArray);
        System.out.println(str3);//abc

        //直接创建
        String str4 = "shabi";//写上双引号,就是字符串
        System.out.println(str4);*/

        //字符串常量池:程序当中直接写上的双引号字符串,就在字符串常量池(在堆当中)中.
        //对于基本类型来说, == 是进行数值的比较.
        //对于引用类型来说, == 是进行[地址值]的比较

        //String比较方法;
        /*String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a','b','c'};
        String str3 = new String(charArray);

        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str2 == str3);//false
        System.out.println(str1.equals(str3));//true

        //推荐:"abc".equals(str) 如果str = null 那么结果是false
        // 不推荐str.equals("abc) 如果str = null 那么结果报错;
        System.out.println("abc".equals(str1));//true*/

        //String获取相关的常用方法:
        /*//1.获取字符串的长度
        int len = "asdasdasdasd".length();
        System.out.println(len);
        //2.拼接字符串
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1.concat(str2);//HelloWorld;
        System.out.println(str3);
        //3.获取指定索引位置的单个字符
        char ch = "hello".charAt(1);
        System.out.println(ch);
        //4.查找参数字符串在本字符串当中首次出现的索引位置,没有则返回-1;
        String str = "helloworldhelloworldhelloworld";
        int index = str.indexOf("wor");
        System.out.println("首次出现: "+index);//5
        System.out.println("hello".indexOf("wor"));//-1*/

        //String的截取方法
        /*String str1 = "HelloWorld";
        String str2 = str1.substring(5);
        System.out.println(str1);//HelloWorld
        System.out.println(str2);//World

        String str3 = str1.substring(4,7);
        System.out.println(str3);//oWo*/

        //String的转换相关方法
        /*String str1 = "HelloWorld";
        //1.转换成字符数组
        char chars[] = str1.toCharArray();
        System.out.println(chars[0]);//H
        //2.转换成字节数组
        byte bytes[] = str1.getBytes();
        System.out.println(bytes[0]);//72
        //3.替换参数
        String str2 = str1.replace("o","*");
        System.out.println(str2);//Hell*W*rld*/

        //String的分割方法
        //注意:split的方法的参数是一个"正则表达式"
        //如果要用"." 必须写成"\\."
        /*String str1 = "aaa,bbb,ccc";
        String[] array1 = str1.split(",");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }

        String str2 = "aaa.bbb.ccc";
        String[] array2 = str2.split(".");
        System.out.println(array2.length);//长度为0

        String[] array3 = str2.split("\\.");
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
        System.out.println(array3.length);//长度为3*/
    }
}
