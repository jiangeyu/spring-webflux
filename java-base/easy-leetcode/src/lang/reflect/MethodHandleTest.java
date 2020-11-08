package lang.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:08 2020/10/22
 */
public class MethodHandleTest {

    private static final String METHOD_NAME = "toString1";

    public static void main(String[] args) {

        MethodHandleTest methodHandleTest = new MethodHandleTest();
        MethodHandle methodHandle = getMethodHandle();

        try {
            String result = (String) methodHandle.invokeExact(methodHandleTest, "zc");
            System.out.println(result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        MethodHandle methodHandle1 = methodHandle.bindTo(methodHandleTest);
        try {
            String result1 = (String) methodHandle1.invokeWithArguments("zc");
            System.out.println(result1);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        Class clazz = MethodHandleTest.class;
        try {
            MethodHandleTest methodHandleTest1 = (MethodHandleTest) clazz.newInstance();
            Method method = clazz.getDeclaredMethod(METHOD_NAME, String.class);
            method.invoke(methodHandleTest1, "ssss");
            methodHandleTest.toString1("w");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private String toString1(String name) {
        System.out.println(name);
        return "method handle," + name;
    }

    public static MethodHandle getMethodHandle() {
        MethodType methodType = MethodType.methodType(String.class, String.class);
        MethodHandle methodHandle = null;
        try {
            methodHandle = MethodHandles.lookup().findVirtual(MethodHandleTest.class, METHOD_NAME, methodType);
            return methodHandle;

        } catch (Exception e) {
            return null;

        }
    }
}
