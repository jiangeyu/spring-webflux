package com.github.oberver.generic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:08 2019/6/7
 */
@FunctionalInterface
public interface PrintWeather {

    void printWeather(String city);

    default void printDefaultWeather(String weatherType) {
        System.out.println(weatherType);
    }
}
