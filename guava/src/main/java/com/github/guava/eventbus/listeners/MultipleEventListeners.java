package com.github.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:26 2019/11/12
 */
@Slf4j
public class MultipleEventListeners {


    @Subscribe
    public void doAction(final String event) {
        log.info("multiple listener received event = {} and will take a action",event);
    }


    @Subscribe
    public void doAction1(final Integer event) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("multiple listener received event = {} and will take a action1",event);

        }

    }

}
