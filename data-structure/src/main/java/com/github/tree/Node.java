package com.github.tree;

import lombok.Data;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:43 2020/12/9
 */
@Data
public class Node {

    public int key;
    public double data;
    public Node leftChild;
    public Node rightNode;

    public void displayNode() {
        System.out.println("*");
        System.out.println(key);
        System.out.println("*");
        System.out.println(data);
    }
}
