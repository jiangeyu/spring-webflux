package com.github.caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * blogs
 *
 * https://juejin.cn/post/6844903670014803981#heading-3
 *
 * https://www.cnblogs.com/rickiyang/p/11074158.html
 */
public class CaffeineTest {

    public static void main(String[] args) {
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .maximumSize(10)
                .build();
        cache.put("hello", "world");
        cache.put("hello1", "world1");
        System.out.println(cache.getIfPresent("hello"));
        System.out.println(cache.getIfPresent("hello1"));
        System.out.println(cache.getIfPresent("newValue"));

        java.util.function.Function<String, String> f = x -> x + "_spinner";

        System.out.println(cache.get("newValue", f));
        System.out.println(cache.getIfPresent("newValue"));

        // 手动加载
        Cache<String, Object> manualCache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10_000)
                .build();

        //同步加载
        LoadingCache<String, Object> loadingCache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(key -> createExpensiveGraph(key));

        String key = "name1";
// 采用同步方式去获取一个缓存和上面的手动方式是一个原理。在build Cache的时候会提供一个createExpensiveGraph函数。
// 查询并在缺失的情况下使用同步的方式来构建一个缓存
        Object graph = loadingCache.get(key);

// 获取组key的值返回一个Map
        List<String> keys = new ArrayList<>();
        keys.add(key);
        Map<String, Object> graphs = loadingCache.getAll(keys);


        //异步加载
        AsyncLoadingCache<String, Object> asyncLoadingCache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                // Either: Build with a synchronous computation that is wrapped as asynchronous
                .buildAsync(key1 -> createExpensiveGraph(key1));
        // Or: Build with a asynchronous computation that returns a future
        // .buildAsync((key, executor) -> createExpensiveGraphAsync(key, executor));


    }
    private static Object createExpensiveGraph(String key) {
        System.out.println("缓存不存在或过期，调用了createExpensiveGraph方法获取缓存key的值");
        if (key.equals("name")) {
            throw new RuntimeException("调用了该方法获取缓存key的值的时候出现异常");
        }
        return null;
    }

}
