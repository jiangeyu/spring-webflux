package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:  225. 用队列实现栈
 * @Date: Created in 下午7:04 2021/3/21
 */
public class MyStack {
    private Queue<Integer> a;//输入队列
    private Queue<Integer> b;//输出队列

    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void push(int x) {
        a.offer(x);
        // 将b队列中元素全部转给a队列
        while (!b.isEmpty())
            a.offer(b.poll());
        // 交换a和b,使得a队列没有在push()的时候始终为空队列
        Queue temp = a;
        a = b;
        b = temp;
    }

    public int pop() {
        return b.poll();
    }

    public int top() {
        return b.peek();
    }

    public boolean empty() {
        return b.isEmpty();
    }
}
