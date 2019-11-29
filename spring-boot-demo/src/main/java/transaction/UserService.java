package transaction;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:33 2019/11/25
 */
public interface UserService {

    int insertUser(User user);

    User getUser(Long id);
}
