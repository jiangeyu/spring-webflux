package declare.parents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:53 2019/5/16
 */
@Aspect
@Component
public class AspectConfig {

    /**
     * 引入新的方法,目标类中再增加一个目标方法
     */
    @DeclareParents(value = "declare.parents.Person+", defaultImpl = FemaleAnimal.class)
    public Animal animal;
}
