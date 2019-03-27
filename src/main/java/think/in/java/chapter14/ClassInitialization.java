package think.in.java.chapter14;

import java.util.Random;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:59 2019/3/26
 */
public class ClassInitialization {



    public static Random random = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {

        /**
         * .class活得对类的引用不会引发初始化
         */
        Class initable = Initable.class;


        Class initale3 = Class.forName("think.in.java.chapter14.Initable3");

        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        System.out.println(bounded.getName());



    }
}
