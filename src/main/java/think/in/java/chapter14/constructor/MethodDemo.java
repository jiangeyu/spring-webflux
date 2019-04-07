package think.in.java.chapter14.constructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午3:48 2019/4/7
 * @desc
 */
public class MethodDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class clazz = Person.class;
        Person person = (Person) clazz.newInstance();

        System.out.println("------Method invoke");
        Method method = clazz.getMethod("draw",int.class, String.class);
        method.invoke(person,28,"zc");

        System.out.println("------Method getMethods");
        Method[] methods = clazz.getMethods();
        Arrays.asList(methods).forEach(method1 -> System.out.println(method1.getName()));


        System.out.println("------Method getDeclaredMethods");
        Method[] methods2 = clazz.getDeclaredMethods();
        Arrays.asList(methods2).forEach(method1 -> System.out.println(method1.getName()));

        System.out.println("------Method getMethods");
        Method[] methods3 = clazz.getDeclaredMethods();
        Arrays.asList(methods3).forEach(method1 -> System.out.println(method1.getName()));


        System.out.println("------Method getDeclaredMethod");
        Method singMethod = clazz.getDeclaredMethod("sing",String.class);
        singMethod.setAccessible(true);
        singMethod.invoke(person, "july");

        System.out.println("------Method getReturnType");
        System.out.println(singMethod.getReturnType());

        System.out.println("------Method getParameterTypes");
        Type[] types = method.getParameterTypes();
        Arrays.asList(types).forEach(type -> type.getTypeName());

    }
}
