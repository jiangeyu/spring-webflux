package com.github.binaryTree;

import java.io.Serializable;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午9:57 2019/5/29
 */
public class BinaryNode<T extends Comparable> implements Serializable {

    private static final long serialVersionUID = -6477238039299912313L;

    public BinaryNode<T> left;

    public BinaryNode<T> right;

    public T data;

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
