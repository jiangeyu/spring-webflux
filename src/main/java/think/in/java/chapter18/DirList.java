package think.in.java.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:37 2019/3/30
 */
public class DirList {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0) {
            list = path.list();
        } else {
//            list = path.list(new DirFilter(args[0]));
            list = path.list((dir, name) -> {
                Pattern pattern = Pattern.compile(args[0]);
                return pattern.matcher(name).matches();
            });
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        Arrays.stream(list).forEach(System.out::println);
    }

    static class DirFilter implements FilenameFilter {

        private Pattern pattern;

        public DirFilter(String regex) {
            this.pattern = Pattern.compile(regex);
        }

        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
