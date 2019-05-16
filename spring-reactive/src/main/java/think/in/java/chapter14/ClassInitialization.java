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

        Class initable = Initialization2.class;

        Class initale2 = Class.forName("think.in.java.chapter14.Initialization");

        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        System.out.println(bounded.getName());



    }
}
