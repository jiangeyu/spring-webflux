package com.github.oberver.generic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午2:12 2019/6/8
 */
public class DefaultPrintWeatherFactory implements PrintWeatherFactory {


    @Override
    public PrintWeather newInstance(final String weatherType) {
        return city -> System.out.println(city + " in " + WeatherType.valueOf(weatherType).toString() + " weather");
    }
}
