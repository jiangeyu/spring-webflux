package think.in.java.chapter18;

import java.io.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:25 2019/4/2
 */
public class BasicFileOutput {

    static String file = "data.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("data.txt")));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lintOut = 1;
        String s;
        while((s = in.readLine()) != null) {
            out.println(s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));


    }
}
