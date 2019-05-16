package think.in.java.chapter14;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:23 2019/3/26
 */
public class Initialization {

    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.random.nextInt(1000);

    static {
        System.out.println("init  Initialization2 " + staticFinal);
        System.out.println("init  Initialization2 ,random " + staticFinal2);
    }


}
