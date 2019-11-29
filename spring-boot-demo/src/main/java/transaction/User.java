package transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:30 2019/11/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("user")
public class User {

    Long id;

    String userName;

    String note;
}
