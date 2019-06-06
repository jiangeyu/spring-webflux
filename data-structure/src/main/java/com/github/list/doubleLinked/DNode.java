package com.github.list.doubleLinked;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:23 2019/6/6
 */
public class DNode<T> {

    public T data;
    public DNode<T> prev, next;//前继指针和后继指针

    public DNode(T data, DNode<T> prev, DNode<T> next)
    {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DNode(T data)
    {
        this(data, null, null);
    }

    public DNode()
    {
        this(null, null, null);
    }

    public String toString()
    {
        return this.data.toString();
    }


}
