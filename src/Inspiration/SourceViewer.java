package Inspiration;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SourceViewer {

    public static void main(String[] args) {
        String t = "https://www.baidu.com/";
        InputStream in = null;
        try {
            //打开URL进行读取
            URL u = new URL(t);
            in = u.openStream();
            //缓冲输入以提升性能
            in = new BufferedInputStream(in);
            //将InputStream串链到一个Reader
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (MalformedURLException ex) {
            System.out.println(t + "is not a parseable URL");
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
