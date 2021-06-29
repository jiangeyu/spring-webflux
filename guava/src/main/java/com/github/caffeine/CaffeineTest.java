package com.github.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

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


    }


}
