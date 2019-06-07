package com.github.oberver.generic;

import java.util.EnumMap;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:13 2019/6/7
 */
public final class WeatherEnumMapConstant {

    public static EnumMap<WeatherType, PrintWeather> weatherEnumMap
            = new EnumMap<>(WeatherType.class);


    public static EnumMap initWeather() {

        DefaultPrintWeatherFactory printWeatherFactory = new DefaultPrintWeatherFactory();

        weatherEnumMap.put(WeatherType.SUNNY, printWeatherFactory.newInstance("SUNNY"));
        weatherEnumMap.put(WeatherType.RAINY, printWeatherFactory.newInstance("RAINY"));
        weatherEnumMap.put(WeatherType.COLD, printWeatherFactory.newInstance("COLD"));
        weatherEnumMap.put(WeatherType.WINDY, printWeatherFactory.newInstance("WINDY"));

        return weatherEnumMap;


    }


}
