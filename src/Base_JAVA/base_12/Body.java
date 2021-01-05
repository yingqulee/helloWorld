package Base_JAVA.base_12;

public class Body {//外部类

    public class Heart{//内部类
        //内部类方法
        public void beat(){
            System.out.println("砰砰砰");
            //System.out.println("名字"+name);//可以访问外部类成员变量
        }

    }

    //外部类的成员变量
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //外部类的方法
    public void methodBody(){
        System.out.println("外部类的方法");
        //间接使用:在外部类的方法当中,使用内部类,然后main只是调用外部类的方法
        /*Heart heart = new Heart();
        heart.beat();*/
        //使用匿名内部类
        new Heart().beat();

    }
}
