package think.in.java.chapter14.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午1:10 2019/4/6
 * @desc
 */
public class ConstructorDemo {

    public static void main(String[] args) throws ClassNotFoundException
            , NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("think.in.java.chapter14.constructor.Person");
        Constructor constructor = clazz.getConstructor(String.class);

        System.out.println("----- Constructor new Instance");
        Person person1 = (Person) constructor.newInstance("zhouchen");
        person1.setAge(12);
        System.out.println(person1.toString());


        System.out.println("----- Constructor getDeclaredConstructor setAccessible");
        Constructor constructor2 = clazz.getDeclaredConstructor(int.class, String.class);
        constructor2.setAccessible(true);
        Person person2 = (Person) constructor2.newInstance(26, "lingxiao");
        System.out.println(person2.toString());

        System.out.println("----- Constructor getDeclaredConstructors getParameterTypes");
        Constructor<?> cons[] = clazz.getDeclaredConstructors();
        Arrays.asList(cons).forEach(con -> {
            Class<?> clazzs[] = con.getParameterTypes();
            for (int i = 0; i < clazzs.length; i++) {
                System.out.println(clazzs[i].getName());
            }
        });

        System.out.println("----- Constructor getGenericParameterTypes");
        Type[] types = constructor2.getGenericParameterTypes();
        Arrays.asList(types).forEach(type -> System.out.println(type.getTypeName()));

        Type[] types2 = constructor2.getParameterTypes();
        System.out.println("----- Constructor getParameterTypes");
        Arrays.asList(types2).forEach(type -> System.out.println(type.getTypeName()));

        System.out.println("----- Constructor getDeclaringClass");
        System.out.println(constructor2.getDeclaringClass().getName());

        System.out.println("----- Constructor toGenericString");
        System.out.println(constructor2.toGenericString());
    }
}
