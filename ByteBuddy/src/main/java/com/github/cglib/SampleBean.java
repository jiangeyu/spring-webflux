package com.github.cglib;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.ImmutableBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/9/2 14:59
 */
public class SampleBean {
  private String name;

  public SampleBean(String name) {
    this.name = name;
  }

  public SampleBean() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    SampleBean bean = new SampleBean();
    bean.setName("Hello world");
    SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean); //创建不可变类
    bean.setName("Hello world, again"); //可以通过底层对象来进行修改
    immutableBean.setName("Hello cglib"); //直接修改将throw exception

    /**
     cglib提供的一个操作bean的工具，使用它能够在运行时动态的创建一个bean。
     */
    BeanGenerator beanGenerator = new BeanGenerator();
    beanGenerator.addProperty("value", String.class);
    Object proxy = beanGenerator.create();
    Method setter = proxy.getClass().getMethod("setValue", String.class);
    setter.invoke(proxy, "hello");

    Method getter = proxy.getClass().getMethod("getValue");
    System.out.println(getter.invoke(proxy));
  }
}
