package A_CodePlay.Tag_String;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序 简单
 *
 * 例如:“I am a student”
 * 输出:“student a am I”
 */
public class NewCoder_ReverseSentence {

    public static String reverseSentence(String str) {
        if(str == null) {
            return null;
        }
        if(str.trim().equals("")){
            return str;
        }
        String[] word = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = word.length - 1; i >= 0; i--) {
            res.append(word[i] + " ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("the sky is blue"));
    }
}
