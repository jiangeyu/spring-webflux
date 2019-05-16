package think.in.java.chapter20;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午7:59 2019/3/26
 * @desc
 */
@DbTable(name = "MEMBER")
public class Member {

    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;

    /**
     * 主键
     */
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public static int getMemberCount() {
        return memberCount;
    }
}
