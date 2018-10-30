package com.github.springwebflux.guava.concurrent;

import com.google.common.util.concurrent.FutureCallback;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午5:13 2018/10/30
 * @desc
 */
public class FutureCallBackImpl implements FutureCallback<String> {

    @Override
    public void onSuccess(String result) {
        System.out.println("call back success");
    }

    @Override
    public void onFailure(Throwable t) {
        System.out.println("call back error");
    }

    public String getCallbackResult() {
        return "result";
    }
}
