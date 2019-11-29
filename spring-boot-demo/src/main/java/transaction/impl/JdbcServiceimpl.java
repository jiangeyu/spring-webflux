package transaction.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transaction.JdbcService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:21 2019/11/25
 */
@Service
public class JdbcServiceimpl implements JdbcService {

    @Autowired
    private DataSource dataSource = null;

    @Override
    public int insertUser(String userName, String note) {

        Connection connection = null;
        int result = 0;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into user(user_name, note) values(?,?)");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, note);

            result = preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();

        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
