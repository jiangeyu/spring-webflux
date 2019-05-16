package think.in.java.chapter14;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:32 2019/3/27
 */
public class FilledList<T> {

    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<>();

        try {
            for(int i=0;i<nElements;i++ ) {
                result.add(type.newInstance());
            }

        } catch (Exception e) {
            new RuntimeException();
        }

        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> filledList =
                new FilledList<>(CountedInteger.class);
        System.out.println(filledList.create(15));

        Number number = new Integer(1);
        System.out.println(number.getClass().getName());
        System.out.println(number.getClass().isAssignableFrom(Integer.class));

        Class<Integer> integerType = Integer.class;

        /**
         * 转型用法
         */
        Integer integer = integerType.cast(number);
        System.out.println(integer);
        System.out.println(number.getClass().getName());

    }
}
