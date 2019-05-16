package think.in.java.chapter13;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:41 2019/5/5
 */
@Slf4j
public class ExceptionTest {

    public static void main(String[] args) {

        try {
            StringTest.test();
        } catch (Exception e) {
            log.error("入参: {}", args[0],e);
            throw new ArithmeticException();
        }

//        System.out.println("异常之后");
    }
}