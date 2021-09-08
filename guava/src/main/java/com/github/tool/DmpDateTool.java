package com.github.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author jiaxue.peng
 * @description
 * @date 2021/8/6 10:04
 */

public class DmpDateTool {

    private Calendar calendar = Calendar.getInstance();

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");


    public DmpDateTool() {
        this(new Date());
    }

    public DmpDateTool(Date date) {
        this.calendar.setTime(date);
    }

    public DmpDateTool addDay(int amount) {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, amount);
        return this;
    }

    public Integer addDayFormat(int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, amount);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyyMMdd");
        return Integer.parseInt(simpleDateFormat.format(calendar.getTime()));
    }

    public DmpDateTool add(int field, int amount) {
        calendar.add(field, amount);
        return this;
    }

    public DmpDateTool set(int field, int amount) {
        calendar.set(field, amount);
        return this;
    }

}
