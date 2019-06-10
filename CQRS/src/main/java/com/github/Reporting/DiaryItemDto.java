package com.github.Reporting;

import lombok.Data;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:52 2019/6/10
 */
@Data
public class DiaryItemDto {

    public String title;
    public Date from;
    public Date to;
    public String description;
}
