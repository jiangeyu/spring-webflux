package com.github.guava.base;

import com.google.common.base.Defaults;
import org.junit.Test;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午3:51 2020/12/30
 */
public class DefaultsTest {

    @Test
    public void test() {
        Boolean b = Defaults.defaultValue(Boolean.class).booleanValue();
        assert b == false;
    }
}
