package Interview;

public class StringPool {

    public static void main(String[] args) {

        /**
         * String::intern()是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的字符串，
         * 则返回代表池中这个字符串的String对象的引用;否则，会将此String对象包含的字符串添加到常量池中，
         * 并且返回此String对象的引用。在JDK 6或更早之前的HotSpot虚拟机中，常量池都是分配在永久代中，
         * 我们可以通过-XX: PermSize和-XX:MaxPermSize限制永久代的大小，即可间接限制其中常量池的容量
         *
         **/
        String str1 = new StringBuilder("Java").append("Script").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern()); //true

        System.out.println();

        String str2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern()); //false
    }
}
