package com.github.cglib;

import com.github.SampleClass;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @author jiaxue.peng
 * @description https://blog.csdn.net/qq_33661044/article/details/79767596
 * @date 2021/9/2 14:26
 */
public class CglibProxy {


  public static void main(String[] args) {
      //Enhancer不能够拦截final方法
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(SampleClass.class);
//    enhancer.setCallback(
//            (MethodInterceptor) (o, method, objects, methodProxy) -> {
//              System.out.println("before method run");
//              Object result = methodProxy.invokeSuper(o, args);
//              System.out.println("after method run");StringSwitcher
//              return result;
//            });
//
      /**
       可以使用一个InvocationHandler(如果对InvocationHandler不懂，可以参考这里)作为回调，
       使用invoke方法来替换直接访问类的方法，但是你必须注意死循环。因为invoke中调用的任何原代理类方法，均会重新代理到invoke方法中。
       */
//      enhancer.setCallback(new InvocationHandler() {
//          @Override
//          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//              if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
//                  return "hello cglib";
//              }else{
//                  throw new RuntimeException("Do not know what to do");
//              }
//          }
//      });
//    enhancer.setCallback(new FixedValue() {
//        @Override
//        public Object loadObject() throws Exception {
//            return "null";
//        }
//    });

      CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
          @Override
          protected Object getCallback(Method method) {
              if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                  return new FixedValue() {
                      @Override
                      public Object loadObject() throws Exception {
                          return "Hello cglib";
                      }
                  };
              }else{
                  return NoOp.INSTANCE;
              }
          }
      };
      enhancer.setSuperclass(SampleClass.class);
      //对特定的方法进行拦截，对其他的方法直接放行，不做任何操作
      enhancer.setCallbackFilter(callbackHelper);
      enhancer.setCallbacks(callbackHelper.getCallbacks());
      SampleClass proxy = (SampleClass) enhancer.create();
      System.out.println(proxy.hashCode());

//      SampleClass proxy = (SampleClass) enhancer.create();
//      proxy.test(null);
//      System.out.println(proxy.toString());
//      System.out.println(proxy.getClass());
//      System.out.println(proxy.hashCode());


  }
}
