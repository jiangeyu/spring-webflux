package com.github.binaryTree;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午9:51 2019/5/29
 */
public interface Tree<T extends Comparable> {

    boolean isEmpty();

    int size();

    int height();

    String preOrder();

    String inOrder();

    String postOrder();

    String levelOrder();

    void insert(T data);

    void remove(T data);

    T findMin();

    T findMax();

    BinaryNode findNode(T data);

    boolean cotains(T data) throws Exception;

    void clear();


}
