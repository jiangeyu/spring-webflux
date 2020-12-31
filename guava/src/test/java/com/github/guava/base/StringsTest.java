package com.github.guava.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.junit.Test;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午3:56 2020/12/30
 */
public class StringsTest {

    @Test
    public void test1() {
        String b = null;
        String a =" ";
        Preconditions.checkState(true, Strings.isNullOrEmpty(b));
        Preconditions.checkState(true,Strings.isNullOrEmpty(a));

        String c = Strings.emptyToNull(a);
        System.out.println(c);
    }
}
