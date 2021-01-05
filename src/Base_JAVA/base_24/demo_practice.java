package Base_JAVA.base_24;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class demo_practice {

    /*
        下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来。要求将打印姓
        名的动作作为第一个 Consumer 接口的Lambda实例，将打印性别的动作作为第二个 Consumer 接口的Lambda实
        例，将两个 Consumer 接口按照顺序“拼接”到一起
     */
    private static void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        for (String info : array) {
            one.andThen(two).accept(info); // 姓名：迪丽热巴。性别：女。
        }
    }

    /*
        数组当中有多条“姓名+性别”的信息如下，请通过 Predicate 接口的拼装将符合要求的字符串筛选到集合
        ArrayList 中，需要同时满足两个条件：
        1. 必须为女生；
        2. 姓名为4个字。
     */
    private static List<String> filter(String[] array, Predicate<String> one,
                                       Predicate<String> two) {
        List<String> list = new ArrayList<>();
        for (String info : array) {
            if (one.and(two).test(info)) {
                list.add(info);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] array1 = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        printInfo(s -> System.out.print("姓名：" + s.split(",")[0]),

                s -> System.out.println("。性别：" + s.split(",")[1] + "。"),

                array1);

        System.out.println("===============================================");

        String[] array2 = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        List<String> list = filter(array2,
                s -> "女".equals(s.split(",")[1]),
                s -> s.split(",")[0].length() == 4);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
