package com.github.Domain.Mementos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:57 2019/6/8
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiaryItemMemento extends BaseMemento {

    public String title;
    public Date from;
    public Date to;
    public String description;


}
