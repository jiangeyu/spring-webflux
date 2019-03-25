package think.in.java.chapter20;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:05 2019/3/25
 */
public class UserCaseTracker {

    public static void trackUserCases(List<Integer> useCases, Class<?> cl) {
        for (Method method : cl.getDeclaredMethods()) {
            UserCase userCase = method.getAnnotation(UserCase.class);
            System.out.println(method.getName());
            if (useCases != null) {
                System.out.println("found UseCase:" + userCase.id());
                useCases.remove(new Integer(userCase.id()));
            }

        }
        for (int i : useCases) {
            System.out.println("warning :Missing use case-" + i);
        }
    }

    public static void main(String[] args) {

        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackUserCases(useCases, PasswordUtils.class);
    }
}
