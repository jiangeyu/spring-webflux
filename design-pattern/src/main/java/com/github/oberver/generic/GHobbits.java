package com.github.oberver.generic;

import com.github.oberver.WeatherType;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:46 2019/6/7
 */
public class GHobbits implements Race {

    @Override
    public void update(WeatherEvent weather, WeatherType weatherType) {
        switch (weatherType) {
            case COLD:
                System.out.println("hobbits in cold weather");
                break;
            case RAINY:
                System.out.println("hobbits in rainy weather");
                break;
            case SUNNY:
                System.out.println("hobbits in sunny weather");
                break;
            case WINDY:
                System.out.println("hobbits in windy weather");
                break;
            default:
                break;
        }
    }
}
