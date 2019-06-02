package com.github.stack;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:00 2019/6/2
 */
public interface Stack<T> {

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * data元素入栈
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素,未出栈
     * @return
     */
    T peek();

    /**
     * 出栈,返回栈顶元素,同时从栈中移除该元素
     * @return
     */
    T pop();

}
