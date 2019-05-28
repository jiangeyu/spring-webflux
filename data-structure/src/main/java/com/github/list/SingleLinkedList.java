package com.github.list;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:17 2019/5/28
 */
public class SingleLinkedList {

    private Node head;
    private Node current;
    private int size;

    public SingleLinkedList() {
        head = current = new Node();
        size = 0;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public int getSize() {
        return size;
    }

    public void addLast(Object obj) {
        Node newNode = new Node(obj);
        current = head.next;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = null;
        size++;
    }

    public void insert(int i, Object value) {
        Node newNode = new Node(value);
        Node prve = head;
        current = head.next;
        int j = 0;
        while (current != null && j < i) {
            prve = current;
            current = current.next;
            j++;
        }
        newNode.next = current;
        prve.next = newNode;
        size++;
    }

    public void delete(int i) {
        Node prve = head;
        current = head.next;
        int j = 0;
        while (current != null && j < i) {
            prve = current;
            current = current.next;
            j++;
        }
        prve.next = current.next;
        size--;
    }

    public Object getValue(int i) {
        current = head.next;
        int j = 0;
        while (current != null && j < i) {
            current = current.next;
            j++;
        }
        return current.value;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("链表为空");
        } else {
            for (Node current = head.next; current != null; current = current.next) {
                System.out.print(current.value + " ");
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        System.out.println("初始线性表：");
        for (int i = 0; i < 10; i++) {
            singleLinkedList.insert(i, new Integer(i));
        }
        singleLinkedList.print();

        System.out.println("在位置4插入元素9后的线性表：");
        singleLinkedList.insert(4, new Integer(9));

        singleLinkedList.print();

//		System.out.println("表头插入元素0后的线性表：");
//		singleLinkedList.addToFirst(new Integer(0));
//		singleLinkedList.print();

        System.out.println("表尾插入元素0后的线性表：");
        singleLinkedList.addLast(new Integer(0));
        singleLinkedList.print();

        System.out.println("删除第5个元素后的线性表：");
        singleLinkedList.delete(5);
        singleLinkedList.print();

    }
}
