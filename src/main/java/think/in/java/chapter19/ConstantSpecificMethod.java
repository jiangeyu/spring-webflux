package think.in.java.chapter19;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午3:01 2019/3/26
 */
public enum ConstantSpecificMethod {
    /**
     *
     */
    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    };

    abstract String getInfo();


    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }

}
