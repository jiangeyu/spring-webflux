package com.github.guava.concurrent;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午8:24 2018/10/30
 * @desc
 */
public class AsyncFunctionSample implements AsyncFunction<Long, String> {

    private ConcurrentMap<Long, String> map = Maps.newConcurrentMap();
    private ListeningExecutorService listeningExecutorService;


    @Override
    public ListenableFuture<String> apply(Long input) throws Exception {
        if (map.containsKey(input)) {
            SettableFuture<String> listenableFuture = SettableFuture.create();
            listenableFuture.set(map.get(input));
            return listenableFuture;
        } else {
            return listeningExecutorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String retrieved = "result";
                    map.putIfAbsent(input, retrieved);
                    return retrieved;
                }
            });
        }
    }
}
