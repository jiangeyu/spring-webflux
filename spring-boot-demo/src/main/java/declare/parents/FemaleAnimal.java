package declare.parents;

import org.springframework.stereotype.Component;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:52 2019/5/16
 */
@Component("femaleAnimal")
public class FemaleAnimal implements Animal {
    @Override
    public void eat() {
        System.out.println(" FemaleAnimal eat ");
    }
}
