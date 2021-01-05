package Base_JAVA.base_12;

/*
1.类作为成员变量类型
==================
2.接口作为成员变量类型
 */
public class demo_03 {

    public static void main(String[] args) {
        /*
        //1.类作为成员变量类型
        //创建一个英雄角色
        Hero hero = new Hero();
        hero.setName("德玛西亚皇子");
        hero.setAge(23);

        //创建一个武器对象
        Weapon weapon = new Weapon("多兰盾");
        hero.setWeapon(weapon);

        hero.attack();*/

        /*
        //2.接口作为成员变量类型
        //创建一个英雄角色
        Hero hero = new Hero();
        hero.setName("艾希");
        //设置技能
        //hero.setSkill(new Skillimpl());//使用了实现类
        hero.setSkill(new Skill() {
            @Override
            public void useSkill() {
                System.out.println("施放大招:Duang~Duang~Duang~");
            }
        });//使用匿名内部类
        hero.attack();*/

        //接口作为方法的参数或返回值
        //左边是接口名称,右边是实现类名称,多态写法
        /*List<String> list = new ArrayList<>();

        List<String> result = addName(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }*/
    }

    /*//接口作为方法的参数或返回值
    public static List<String> addName(List<String> list){
        list.add("真的假的");
        list.add("假的真的");
        list.add("真亦假时假亦真");
        return list;
    }*/
}
