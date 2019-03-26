package think.in.java.chapter19;

import java.util.Random;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:49 2019/3/26
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    /**
     *
     */
    SLAPPY,
    SPANKY,
    SILLY,
    BOUNCY,
    NUTTY,
    BOB;

    private Random random = new Random(45);

    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }

    public class EnumIMplementation {
        public  <T> void printNext(Generator<T> rg) {
            System.out.println(rg.next() + ".");
        }
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            System.out.println(cc.next());
        }
    }


}
