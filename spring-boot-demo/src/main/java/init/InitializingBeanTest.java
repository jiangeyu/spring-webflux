package init;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:56 2019/7/1
 */
public class InitializingBeanTest implements InitializingBean {

    private String testEnv;

    public void setTestEnv(String testEnv) {
        this.testEnv = testEnv;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----- InitializingBean");
    }
}
