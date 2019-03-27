package think.in.java.chapter15;

import think.in.java.chapter14.CountedInteger;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午5:04 2019/3/27
 */
public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }

    public static void main(String[] args) {
        Generator<CountedInteger> generator = BasicGenerator.create(CountedInteger.class);

        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
    }
}
