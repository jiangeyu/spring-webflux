package com.github.oberver.generic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:46 2019/6/7
 */
public class GHobbits implements Race {

    static final String city = "Orcs";

    @Override
    public void update(WeatherEvent weather, WeatherType weatherType) {
        print(weatherType, city);
    }
}
