package com.github.stack;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:17 2019/6/2
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node() {

    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

}
