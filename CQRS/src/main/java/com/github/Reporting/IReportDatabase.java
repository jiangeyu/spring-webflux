package com.github.Reporting;

import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:53 2019/6/10
 */
public interface IReportDatabase {

    DiaryItemDto getById(String id);

    void add(DiaryItemDto itemDto);

    void delete(String id);

    List<DiaryItemDto> getItems();
}
