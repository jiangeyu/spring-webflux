package com.github.Commands;

import lombok.Data;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:28 2019/6/10
 */
@Data
public class ChangeItemCommand extends Command {

    public String title;
    public Date from;
    public Date to;
    public String description;

    public ChangeItemCommand(String id, int version, String title, Date from, Date to, String description) {
        super(id, version);
        this.title = title;
        this.from = from;
        this.to = to;
        this.description = description;
    }
}
