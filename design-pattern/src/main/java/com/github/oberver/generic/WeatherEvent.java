package com.github.oberver.generic;


/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:12 2019/6/7
 */
public class WeatherEvent extends Observable<WeatherEvent, Race, WeatherType> {

    private WeatherType currentWeather;

    public WeatherEvent() {
        this.currentWeather = WeatherType.SUNNY;
    }

    public void changeWeather() {

        WeatherType[] weatherTypes = WeatherType.values();

        currentWeather = weatherTypes[(currentWeather.ordinal() + 1) % weatherTypes.length];

        notifyObservers(currentWeather);
    }
}
