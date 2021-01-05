package Base_JAVA.base_04;

public class practice {

    /*public static String fromArrayToString(int[] array){
    *//*
    题目1:定义一个方法,把数组{1,2,3}按照指定格式拼接成一个字符串.参照如下:[word1#word2#word3].
    *//*
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1){
                str += "word: " + array[i] + "]";
            }else {
                str += "word: " + array[i] + "# ";
            }
        }
        return str;
    }*/

    public static void main(String[] args) {
        /*//题目1
        int a[] = {1,2,3};
        String str = fromArrayToString(a);
        System.out.println(str);*/

        //题目2:键盘输入一个字符串,统计各种字符出现的次数;
        /*Scanner in = new Scanner(System.in);
        String str = in.next();

        int countUpper = 0;//大写字母
        int countLower = 0;//小写字母
        int countNumber = 0;//数字
        int countOther = 0;//其他..

        char  charArray[] = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];//当前单个字符
            if ('A' <= ch && ch <= 'Z'){
                countUpper++;
            }else if ('a' <= ch && ch <= 'z'){
                countLower++;
            }else if ('0' <= ch && ch <= '9'){
                countNumber++;
            }else{
                countOther++;
            }
        }
        System.out.println("大写字母有: "+countUpper+","+"小写字母有: "+countLower+","+"数字有: "+countNumber+","+"其他的: "+countOther+".");*/
    }
}
