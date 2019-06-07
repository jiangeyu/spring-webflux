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

        PrintWeather printWindyWeather = new PrintWeather() {
            @Override
            public void printWeather(String city) {
                printDefaultWeather(city + " in " + WeatherType.WINDY.toString() + " weather");
            }
        };

        PrintWeather printSunnyWeather = new PrintWeather() {
            @Override
            public void printWeather(String city) {
                printDefaultWeather(city + " in " + WeatherType.SUNNY.toString() + " weather");
            }
        };

        PrintWeather printColdWeather = new PrintWeather() {
            @Override
            public void printWeather(String city) {
                printDefaultWeather(city + " in " + WeatherType.COLD.toString() + " weather");
            }
        };

        PrintWeather printRainyWeather = new PrintWeather() {
            @Override
            public void printWeather(String city) {
                printDefaultWeather(city + " in " + WeatherType.RAINY.toString() + " weather");
            }
        };


        weatherEnumMap.put(WeatherType.WINDY, printWindyWeather);
        weatherEnumMap.put(WeatherType.RAINY, printRainyWeather);
        weatherEnumMap.put(WeatherType.COLD, printColdWeather);
        weatherEnumMap.put(WeatherType.SUNNY, printSunnyWeather);


        return weatherEnumMap;


    }


}
