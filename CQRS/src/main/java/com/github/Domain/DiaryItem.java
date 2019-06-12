package com.github.Domain;

import com.github.Events.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:59 2019/6/8
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryItem extends AggregateRoot
        implements IHandle<ItemCreateEvent>,
        IHandle<ItemRenameEvent>,
        IHandle<ItemFromChangeEvent>,
        IHandle<ItemToChangeEvent,
                IHandle<ItemDescriptionChangeEvent> {


    private String title;
    private Date from;
    private Date to;
    private String description;
    @Override
    public void handle(ItemCreateEvent e) {

    }
}
