package Base_JAVA.base_07;

/*
发红包的案例:继承相关的知识
 */

import java.util.ArrayList;

public class demo_02 {

    public static void main(String[] args) {
        //首先 创建一个群主
        Manager manager = new Manager("群主",200);

        Member member1 = new Member("成员A ",0);
        Member member2 = new Member("成员B ",0);
        Member member3 = new Member("成员C ",0);

        manager.show();
        member1.show();
        member2.show();
        member3.show();
        System.out.println("===============");

        //群主发了20,分成3份
        ArrayList<Integer> redList = manager.send(20,3);
        //三个普通成员收红包
        member1.receive(redList);
        member2.receive(redList);
        member3.receive(redList);

        manager.show();

        member1.show();
        member2.show();
        member3.show();

    }
}
