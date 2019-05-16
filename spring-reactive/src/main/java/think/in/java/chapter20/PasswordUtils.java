package think.in.java.chapter20;

import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午6:56 2019/3/25
 */
public class PasswordUtils {

    @UserCase(id = 47, description = "password must contain at least on number")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UserCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UserCase(id = 49, description = "new password cannot equal previous password")
    public boolean checkForNewPassword(List<String> prevPassword, String password) {
        return !prevPassword.contains(password);
    }

}
