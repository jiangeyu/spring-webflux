package think.in.java.chapter19;

import java.util.EnumSet;

import static think.in.java.chapter19.AlarmPoints.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午1:59 2019/3/26
 */
public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(OFFICE1);
        System.out.println(points);

        points.addAll(EnumSet.of(STAIR2, STAIR1,OFFICE1,OFFICE2,OFFICE3));
        System.out.println(points);


        points.removeAll(EnumSet.range(OFFICE1,OFFICE3));
        System.out.println(points);

        points = EnumSet.complementOf(points);
        System.out.println(points);

    }

}
