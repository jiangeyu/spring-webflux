package transaction.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import transaction.User;
import transaction.UserBatchService;
import transaction.UserService;
import transaction.dao.UserDao;

import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午5:51 2019/11/29
 */
@Service
public class UserBatchServiceImpl implements UserBatchService , ApplicationContextAware {

    @Autowired
    private UserDao userDao;

    private ApplicationContext applicationContext = null ;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> userList) {
        int count = 0;
        UserService userService = applicationContext.getBean(UserService.class);
        for(User user : userList) {
            count += userService.insertUser(user);
        }
        return count;
    }



    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

//@Service
//public class UserBatchServiceImpl implements UserBatchService {
//
//    @Autowired
//    private UserDao userDao;
//
//
//    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
//    public int insertUsers(List<User> userList) {
//        int count = 0;
//
//        for(User user : userList) {
//            count += insertUser(user);
//        }
//        return count;
//    }
//
//
//
//    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW)
//    public int insertUser(User user) {
//        return userDao.insertUser(user);
//    }
//}
