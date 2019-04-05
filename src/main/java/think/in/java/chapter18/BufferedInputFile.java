package think.in.java.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description: 基本文件读取
 * @Date: Created in 上午9:17 2019/4/5
 */
public class BufferedInputFile {

    public static String read(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s=in.readLine())!=null) {
            sb.append(s+"\n");

        }

        in.close();
        return sb.toString();

    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("data.txt"));
    }
}
