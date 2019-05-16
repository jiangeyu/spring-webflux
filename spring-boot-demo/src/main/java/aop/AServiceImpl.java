package aop;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午9:46 2018/9/19
 * @desc  事物切面
 */
@Service("AService")
public class AServiceImpl implements AService {

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void a() {
        System.out.println("call method a");
        this.b();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void b() {
        System.out.println("call method b");
    }
}
