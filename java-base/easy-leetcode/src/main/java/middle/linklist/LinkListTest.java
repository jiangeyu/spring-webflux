package middle.linklist;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:54 2021/4/27
 */
public class LinkListTest {

    /**
     * k个 一组翻转链表
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next;
        dummy.next = prev;
        int length = 1;
        while (head != null) {
            head = head.next;
            length++;
        }
        int group = length / k;
        for (int i = 0; i < group; i++) {
            for (int j = 0; j < k - 1; j++) {
                next = cur.next;
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = cur;
            cur = prev.next;

        }
        return dummy.next;

    }
}
