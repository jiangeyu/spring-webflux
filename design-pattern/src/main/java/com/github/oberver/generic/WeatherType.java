package com.github.oberver.generic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:01 2019/6/7
 */
public enum WeatherType {

    /**
     *
     */
    SUNNY("sunny day"), RAINY("rainy day"), WINDY("windy day"), COLD("cold day");

    private String description;

     WeatherType(String description) {
        this.description = description;
    }

    public static WeatherType parse(String description) {
        for (WeatherType weatherType : WeatherType.values()) {
            if (weatherType.toString().equals(description)) {
                return weatherType;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return description;
    }

    public static void main(String[] args) {
        System.out.println(WeatherType.valueOf("SUNNY").toString());
    }
}
