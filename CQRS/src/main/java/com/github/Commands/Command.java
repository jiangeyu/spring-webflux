package com.github.Commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:24 2019/6/10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Command implements ICommand{

    public String id;

    public int version;
}
