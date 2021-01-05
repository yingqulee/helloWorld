package Base_JAVA.base_22;

import java.io.*;
import java.util.HashMap;

/*
观察文本文件的规律：
    1. 每一行都用一个数字开头，格式“数字+.+中文字符串”，有固定格式，用英文句点作为了分隔。
    2. 数字没有重复，可以使用数字作为从小到大排序的依据。
    3. 数字后面的中文内容，应该跟着数字走。需要制定一个数字与中文内容之间的映射关系（对照关系，Map）

思路步骤：
    1. 创建一个缓冲的字符输入流，读取源文件：BufferedReader、readLine()-->String
    2. 需要将每一行字符串拆分成为数字、中文两个部分：split("\\.") --> String[]
    3. 数字和中文内容存在映射关系的，所以使用一个Map<Integer, String>
    4. 将字符串拆分出来的数字、中文两个部分放入Map当中。
        4.1 array[0]是一个字符串，转换成为int数字：Integer.parseInt方法
        4.2 array[1]是一个字符串，直接使用
        4.3 通过Map接口的put(key,value)方法放入数字和字符串。
    5. 关闭输入流。
    6. 创建一个缓冲的字符输出流，写目标文件：BufferedWriter
    7. 数字编号是1、2、3、...9，这就是一个for循环。
    8. 变量i应该对应一个字符串，通过Map当中的get方法获取每一个数字对应的字符串。
    9. 将数字和对应的字符串拼到一起，写到输出流当中。
    10. 关闭输出流。
*/
public class demo_Practice {
    public static void main(String[] args) throws IOException {
        HashMap<String,String> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\123.txt"));

        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\黑马IDEA教程\\B站IDEA教程资料\\advance59-1-13\\day10-code\\OTWResult.txt"));

        String line;
        while((line = br.readLine())!= null){
            String[] arr = line.split("\\.");
            map.put(arr[0], arr[1]);
        }


        for (String key : map.keySet()) {
            String value = map.get(key);
            line = key+"."+value;

            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

    }
}
