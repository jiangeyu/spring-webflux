package com.github.bytebuddy;

import com.github.SampleClass;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/9/2 14:38
 */
public class ByteBuddyProxy {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
      Class<?> dynamicType = new ByteBuddy()
              .subclass(SampleClass.class)
              .method(ElementMatchers.named("test"))
              .intercept(MethodDelegation.to(SampleClass.class))
              .make()
              .load(ByteBuddyProxy.class.getClassLoader())
              .getLoaded();
        SampleClass proxy = (SampleClass) dynamicType.newInstance();
        proxy.test(null);

    }
}
