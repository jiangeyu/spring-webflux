package com.github.Commands;

import lombok.Data;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:31 2019/6/10
 */
@Data
public class CreateItemCommand extends Command {

    public String title;
    public Date from;
    public Date to;
    public String description;

    public CreateItemCommand(String id, int version, String title, Date from, Date to, String description) {
        super(id, version);
        this.title = title;
        this.from = from;
        this.to = to;
        this.description = description;
    }
}
