package think.in.java.chapter19;

import java.util.EnumMap;
import java.util.Map;

import static think.in.java.chapter19.AlarmPoints.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:20 2019/3/26
 */
public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints,Command> enumMap = new EnumMap<>(AlarmPoints.class);

        enumMap.put(OFFICE1, () -> System.out.println("office1"));

        enumMap.put(OFFICE2, () -> System.out.println("office2"));

        for(Map.Entry<AlarmPoints, Command> e : enumMap.entrySet()) {
            System.out.println(e.getKey());
            e.getValue().action();
        }

        enumMap.get(OFFICE1).action();
    }
}
