package lang.nio;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:08 2020/11/14
 */
public class TextFile extends ArrayList<String> {

    public static String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()));

            String tmp = null;
            while ((tmp = bufferedReader.readLine()) != null) {
                stringBuilder.append(tmp);
                stringBuilder.append("\n");
            }

        } catch (IOException e) {

        } finally {
        }
        return stringBuilder.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter printWriter = new PrintWriter(new File(fileName).getAbsoluteFile());
            printWriter.write(text);
        } catch (IOException e) {

        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals(" ")) {
            remove(0);
        }
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter printWriter = new PrintWriter(new File(fileName).getAbsoluteFile());

            for (String item : this) {
                printWriter.println(item);
            }
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {
//        String file = read("/Users/zhouchen/IdeaProjects/spring-webflux/java-base/easy-leetcode/src/lang/nio/TextFile.java");
        String file = read("TextFile.java");

        write("text.txt", file);

        TextFile textFile = new TextFile("text.txt");
        textFile.write("text2.txt");

        TreeSet<String> words = new TreeSet<>(
                new TextFile("TextFile.java", "\\w+")
        );

        System.out.println(words.headSet("a"));


    }
}
