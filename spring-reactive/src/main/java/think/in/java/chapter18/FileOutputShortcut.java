package think.in.java.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午9:37 2019/4/5
 */
public class FileOutputShortcut {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("data.txt")));
        PrintWriter out = new PrintWriter("test.out");
        int lineCount = 1;
        String s;
        while((s=in.readLine()) != null) {
            out.println(lineCount++ + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read("test.out"));

    }
}
