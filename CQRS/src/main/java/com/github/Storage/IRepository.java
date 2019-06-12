package com.github.Storage;

import com.github.Domain.AggregateRoot;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:20 2019/6/10
 */
public interface IRepository<T extends AggregateRoot> {

    void save(AggregateRoot aggregateRoot, int version);

    T getById(String id);


}
