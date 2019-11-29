package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:35 2019/11/25
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @Autowired
    private UserBatchService userBatchService;


    @GetMapping("getUser")
    @ResponseBody
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/insertUser")
    @ResponseBody
    public Map<String, Object> insertUser(String userName, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);

        int update = userService.insertUser(user);
        Map<String, Object> map = new HashMap<>();

        map.put("success", update == 1);
        map.put("user", user);
        return map;
    }

    @GetMapping("/insertUsers")
    @ResponseBody
    public Map<String, Object> insertUsers(String userName, String note) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);

        User user1 = new User();
        user1.setUserName(userName);
        user1.setNote(note);

        list.add(user);
        list.add(user1);
        int update = userBatchService.insertUsers(list);
        Map<String, Object> map = new HashMap<>();

        map.put("success", update > 1);
        map.put("user", user);
        return map;
    }
}
