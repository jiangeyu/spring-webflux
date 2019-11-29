package transaction;

import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午5:50 2019/11/29
 */
public interface UserBatchService {

    int insertUsers(List<User> userList);

    int insertUser(User user);
}
