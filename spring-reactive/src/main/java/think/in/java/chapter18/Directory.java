package think.in.java.chapter18;

import com.google.common.collect.Lists;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:54 2019/3/30
 */
public class Directory {

    public static File[] local(File dir, final String regex) {
        return dir.listFiles((dir1, name) -> {
            Pattern pattern = Pattern.compile(regex);
            return pattern.matcher(name).matches();
        });
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = Lists.newArrayList();
        public List<File> dirs = Lists.newArrayList();


        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "TreeInfo{" +
                    "files=" + files +
                    ", dirs=" + dirs +
                    '}';
        }
    }

    public static TreeInfo walk(String fileName, String regex) {
        return recurseDirs(new File(fileName), regex);
    }

    public static TreeInfo walk(File file, String regex) {
        return recurseDirs(file, regex);
    }

    public static TreeInfo walk(String fileName) {
        return recurseDirs(new File(fileName), ".*");
    }


    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.print(walk("."));
        } else {
            for (String arg : args) {
                System.out.printf(walk(arg).toString());
            }
        }

    }
}
