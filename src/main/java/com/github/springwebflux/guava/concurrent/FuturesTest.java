package com.github.springwebflux.guava.concurrent;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Executors;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午5:37 2018/10/26
 * @desc
 */
public class FuturesTest {

    public static void main(String[] args) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture expolsion = service.submit(() -> {});

        Futures.addCallback(expolsion, new FutureCallback<Object>() {

            @Override
            public void onSuccess(Object result) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
