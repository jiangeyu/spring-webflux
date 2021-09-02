package com.github.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/9/2 14:26
 */
public class SampleClass {
  public void test() {
    System.out.println("hello world");
  }

  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(SampleClass.class);
    enhancer.setCallback(
            (MethodInterceptor) (o, method, objects, methodProxy) -> {
              System.out.println("before method run");
              Object result = methodProxy.invokeSuper(o, args);
              System.out.println("after method run");
              return result;
            });
      SampleClass sampleClass = (SampleClass) enhancer.create();
      sampleClass.test();

  }
}
