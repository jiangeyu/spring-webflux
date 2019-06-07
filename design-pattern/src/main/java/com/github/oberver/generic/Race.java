package com.github.oberver.generic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:13 2019/6/7
 */
public interface Race extends WeatherObserver<WeatherEvent, Race, WeatherType> {

    default void print(WeatherType weatherType, String city) {
        switch (weatherType) {
            case COLD:
                WeatherEnumMapConstant.weatherEnumMap
                        .get(WeatherType.COLD)
                        .printWeather(city);
                break;
            case RAINY:
                WeatherEnumMapConstant.weatherEnumMap
                        .get(WeatherType.RAINY)
                        .printWeather(city);
                break;
            case SUNNY:
                WeatherEnumMapConstant.weatherEnumMap
                        .get(WeatherType.SUNNY)
                        .printWeather(city);
                break;
            case WINDY:
                WeatherEnumMapConstant.weatherEnumMap
                        .get(WeatherType.WINDY)
                        .printWeather(city);
                break;
            default:
                break;
        }
    }
}
