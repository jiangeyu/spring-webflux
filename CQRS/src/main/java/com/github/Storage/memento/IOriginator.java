package com.github.Storage.memento;

import com.github.Domain.Mementos.BaseMemento;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:22 2019/6/10
 */
public interface IOriginator {

    BaseMemento getMemnto();

    void setMemento(BaseMemento memento);
}
