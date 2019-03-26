package think.in.java.chapter19;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午8:48 2019/3/26
 * @desc
 */
enum Explore {HRRE, THERE}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        for(Type type:enumClass.getGenericInterfaces()) {
            System.out.println(type);
        }
        System.out.println(enumClass.getSuperclass());

        Set<String> methods = new TreeSet<>();
        for(Method method: enumClass.getDeclaredMethods()){
            methods.add(method.getName());

        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        System.out.println(exploreMethods.contains(enumMethods));


    }

}
