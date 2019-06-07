package com.github.oberver;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:01 2019/6/7
 */
public enum WeatherType {

    /**
     *
     */
    SUNNY("sunny day"),RAINY("rainy day"),WINDY("windy day"),COLD("cold day");

    private String description;

    WeatherType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WeatherType{" +
                "description='" + description + '\'' +
                '}';
    }
}
