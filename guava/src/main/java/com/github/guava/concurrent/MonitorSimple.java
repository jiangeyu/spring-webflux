package com.github.guava.concurrent;

import com.google.common.util.concurrent.Monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午4:41 2018/10/30
 * @desc
 */
public class MonitorSimple {

    private List<String> list = new ArrayList<>();
    private static final int MAX_SIZE = 10;

    private Monitor monitor = new Monitor();

    private Monitor.Guard listBellowCapacity = new Monitor.Guard(monitor) {
        @Override
        public boolean isSatisfied() {
            return list.size() < MAX_SIZE;
        }
    };

    public void addToList(String item) throws InterruptedException {
        monitor.enterWhen(listBellowCapacity);
        try {
            list.add(item);
        } finally {
            monitor.leave();
        }
    }
}
