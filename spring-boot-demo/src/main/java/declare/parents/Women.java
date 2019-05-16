package declare.parents;

import org.springframework.stereotype.Component;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:39 2019/5/16
 */
@Component("women")
public class Women implements Person {
    @Override
    public void likePerson() {
        System.out.println("woman like man");
    }
}
