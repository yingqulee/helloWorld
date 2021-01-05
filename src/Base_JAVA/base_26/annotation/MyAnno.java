package Base_JAVA.base_26.annotation;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

public @interface MyAnno {

    /*
    属性的返回值类型有下列取值
    * 基本数据类型
    * String
    * 枚举
    * 注解
    * 以上类型的数组
     */
     int value();
    Person per();
    MyAnno2 anno2();
    String[] strs();
     /*String name() default "张三";*/
     /*String show2();

     Person per();
     MyAnno2 anno2();

     String[] strs();*/


}
