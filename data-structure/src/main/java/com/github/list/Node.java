package com.github.list;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:15 2019/5/28
 */
public class Node {

    Object value;
    Node next;

    public Node() {

    }

    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(Object value) {
        this(value, null);
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
