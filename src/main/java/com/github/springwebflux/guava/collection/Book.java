package com.github.springwebflux.guava.collection;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import lombok.Data;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午3:01 2018/10/29
 * @desc
 */
@Data
public class Book implements Comparable<Book> {

    private String[] tittle;
    private String publisher;
    private double price;

    @Override
    public int compareTo(Book o) {
        return ComparisonChain.start()
                .compare(this.publisher, o.publisher)
                .compare(this.price, o.price)
                .result();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", tittle)
                .add("price", price)
                .toString();
    }


    @Override
    public int hashCode() {

        return Objects.hashCode(tittle, publisher, price);
    }


}
