package transaction;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:20 2019/11/25
 */
public interface JdbcService {

    int insertUser(String userName, String note);
}
