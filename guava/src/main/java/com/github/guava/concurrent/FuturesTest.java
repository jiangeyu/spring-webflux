package com.github.guava.concurrent;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午5:37 2018/10/26
 * @desc
 */
public class FuturesTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ListeningExecutorService listeningDecorator = MoreExecutors.listeningDecorator(executorService);
        ListenableFuture<String> future = listeningDecorator.submit(() -> "hello");

        FutureCallBackImpl callBack = new FutureCallBackImpl();

        Futures.addCallback(future, callBack);
        System.out.println(callBack.getCallbackResult());




    }
}
