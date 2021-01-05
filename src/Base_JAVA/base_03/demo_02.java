package Base_JAVA.base_03;

public class demo_02 {

    /*
    定义方法priintArrayList--使输出成我们想要的格式
         */
    /*public static void priintArrayList(ArrayList<String> list){
        //格式{1@2@3}
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (i == list.size() - 1){
                System.out.println(name + "}");
            }else {
                System.out.print(name + "@");
            }
        }
    }*/

    /*
    定义方法smallList--筛选出随机数放进集合中
     */
    /*public static ArrayList<Integer> getsmallList(ArrayList<Integer> bigList){
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            int num = bigList.get(i);
            if (num % 2 == 0){
                smallList.add(num);
            }
        }
        return smallList;
    }*/

    public static void main(String[] args) {
        /*对象数组练习:
        定义一个数组,用来存储3个Person对象
        首先创建一个长度为3的数组*/
        //缺点:数组一旦创建运行期间长度不可改变
        /*Person arr[] = new Person[3];

        Person one = new Person("德玛西亚",20);
        Person two = new Person("德邦总管",20);
        Person three = new Person("蛮族之王",20);

        arr[0] = one;
        arr[1] = two;
        arr[2] = three;

        System.out.println(arr[0]);//没有toSting方法, 返回的就是地址值
        System.out.println(arr[1]);//没有toSting方法, 返回的就是地址值
        System.out.println(arr[2]);//没有toSting方法, 返回的就是地址值

        System.out.println(arr[0].getName());*/

        //ArrayList练习:
        /*
        弥补数组长度不可变的缺点
        ArrayList集合的长度是可以随意改变的

        对于ArrayList来说,有一个<E>代表泛型
        泛型:装在集合当中的所有元素,全都是统一的什么类型
        注意:泛型只能是引用类型,不能是基本类型
         */

        //创建一个ArrayList集合,集合的名称是list,里面全是String字符串类型的数据
        //直接打印的不是地址值,而是内容,如果是空,得到的是[];
        /*ArrayList<String> list = new ArrayList<>();
        System.out.println(list);//[]

        //添加方法add.
        list.add("皎月女神");
        System.out.println(list);*/

        //随机数+ArrayList练习
       /* ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(6)+1;
            list.add(num);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
        //ArrayList练习1--存储自定义对象
        /*ArrayList<Person> list = new ArrayList<>();

        Person person1 = new Person("张无忌",18);
        Person person2 = new Person("哈哈哈",18);
        Person person3 = new Person("哦哦哦",18);
        Person person4 = new Person("嗯嗯嗯",18);

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            System.out.println("姓名: "+person.getName()+" 年龄: "+person.getAge());
        }*/
        //ArrayList练习2--按指定格式遍历集合字符串
        /*ArrayList<String> list = new ArrayList<>();
        list.add("你是谁");
        list.add("我是谁");
        list.add("他是谁");
        list.add("她是谁");

        System.out.println(list);//[你是谁, 我是谁, 他是谁, 她是谁]
        priintArrayList(list);*/

        //ArrayList练习3--筛选随机集合中的偶数
        /*ArrayList<Integer> biglist = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomNum = random.nextInt(20)+1;
            biglist.add(randomNum);
        }
        for (int i = 0; i < biglist.size(); i++) {
            System.out.print(biglist.get(i)+" ");
        }
        System.out.println();
        ArrayList<Integer> smallList = getsmallList(biglist);
        for (int i = 0; i < smallList.size(); i++) {
            System.out.print(smallList.get(i)+" ");
        }*/

    }
}
