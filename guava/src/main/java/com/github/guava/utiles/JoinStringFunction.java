package com.github.guava.utiles;

import com.github.springwebflux.guava.collection.Book;
import com.google.common.base.Joiner;

import java.util.function.Function;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午8:21 2018/10/29
 * @desc
 */
public class JoinStringFunction implements Function<Book, String> {


    @Override
    public String apply(Book book) {
        return Joiner.on(",").join(book.getTittle());
    }
}
