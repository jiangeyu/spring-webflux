package transaction.dao;

import org.springframework.stereotype.Repository;
import transaction.User;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:31 2019/11/25
 */

@Repository
public interface UserDao {

    int insertUser(User user);

    User getUser(Long id);
}
