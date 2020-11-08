package lang;

import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:52 2020/10/17
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Apple apple = new Apple();
        Class clazz = apple.getClass();
        print(clazz.getName());
        print(clazz.getSimpleName());
        print(clazz.getCanonicalName());
        print(clazz.getTypeName());

        Class clazz1 = Class.forName("lang.Apple");
        print(clazz1.getTypeName());

        ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();
        Constructor<?> constructor = reflectionFactory.newConstructorForSerialization(Apple.class, Object.class.getDeclaredConstructor());
        constructor.setAccessible(true);
        Apple instance = (Apple) constructor.newInstance();
        System.out.println(instance.getClass().getName());
        print(instance.getName());


    }


    public static void print(String string) {
        System.out.println(string);
    }


}
