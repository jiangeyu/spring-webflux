package think.in.java.chapter14;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:12 2019/3/26
 */
abstract class Shape {

    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    abstract public String toString();
}
