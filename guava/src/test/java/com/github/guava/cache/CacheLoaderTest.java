package com.github.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import junit.framework.TestCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:42 2019/10/31
 */
public class CacheLoaderTest extends TestCase {

    private boolean isTrue = false;

    public void testBasic() throws ExecutionException, InterruptedException {

        LoadingCache<String, Employee> cache = CacheBuilder
                .newBuilder()
                .maximumSize(10)
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build(createCacheLoader());

        Employee employee = cache.get("zhouchen");
        assertThat(employee, notNullValue());

        assertLoadFromDBThenReset();

        TimeUnit.MICROSECONDS.sleep(31);

        assertThat(employee, notNullValue());

        assertLoadFromDBThenReset();

    }


    private CacheLoader<String, Employee> createCacheLoader() {
        return new CacheLoader<String, Employee>() {

            @Override
            public Employee load(String name) throws Exception {
                return findEmployeeByName(name);
            }
        };
    }

    private void assertLoadFromDBThenReset()
    {
        assertThat(true, equalTo(isTrue));
        this.isTrue = false;
    }

    private Employee findEmployeeByName(final String name) {
        //System.out.println("The employee " + name + " is load from DB.");
        isTrue = true;
        return new Employee(name, name, name);
    }
}
