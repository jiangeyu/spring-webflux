package think.in.java.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:38 2019/4/5
 */
public class OSExcute {

    public static void command(String command) {
        boolean err = false;

        try {
            Process process =  new ProcessBuilder(command.split(" ")).start();
            BufferedReader result = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s;
            while((s = result.readLine())!= null) {
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err= true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(err) {
            throw new RuntimeException("command");
        }
    }
}
