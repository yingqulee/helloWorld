package Base_JAVA.base_05;


/*
java.util.Arrays

是一个与数组相关的工具类,里面提供了大量静态方法,用来实现数组的常见的操作.

如果是自定义的类型,那么这个自定义的类需要有Comparable或者Comparator接口支持/
 */
public class demo_02 {

    public static void main(String[] args) {
        /*int[] intArray = {1,2,3};
        //将int[]数组按照默认格式变成字符串
        String instr = Arrays.toString(intArray);
        System.out.println(instr);//[1, 2, 3]

        //如果是数值,sort默认按照升序从小到大
        int[] arr1 = {5,6,7,1,0,5,5,6,1,2};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));//[0, 1, 1, 2, 5, 5, 5, 6, 6, 7]
        //如果是字符串,sort默认按照字母升序
        String[] arr2 = {"bbb","ccc","aaa"};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));//[aaa, bbb, ccc]*/

        //Arrays练习:将以个随机字符串的所有字符升序排列,倒序输出
        /*String str = "asdasddsoyasvuvsdcliwoil";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = chars.length-1; i >= 0; i--) {
            System.out.print(chars[i]+" ");
        }*/
    }
}
