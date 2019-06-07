package com.github.oberver.generic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:00 2019/6/7
 */
public class App {

    public static void main(String[] args) {

        WeatherEvent event = new WeatherEvent();
        event.addObserver(new GHobbits());
        event.addObserver(new GOrcs());

        event.changeWeather();
        event.changeWeather();

        Race race = event.getObservers().get(0);
        event.removeObserver(race);

        System.out.println("----------");
        event.changeWeather();
    }
}
