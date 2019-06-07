package com.github.oberver.generic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午2:10 2019/6/8
 */
public interface PrintWeatherFactory {

    PrintWeather newInstance(final String weatherType);
}
