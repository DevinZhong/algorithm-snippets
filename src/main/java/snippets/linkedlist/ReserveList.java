package snippets.linkedlist;

/**
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/">https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/</a>
 * @author devin
 * @since 2021/12/10 8:53 下午
 */
public class ReserveList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prevNode = null;
        ListNode nextNode;
        while (head.next != null) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        head.next = prevNode;
        return head;
    }

    /**
     * 递归的思想
     *
     * @param head 需要反转的链表头节点
     * @return 反转后的链表头节点
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode headNext = head.next;
        head.next = null;
        return reverseList2Inner(head, headNext);
    }

    public static ListNode reverseList2Inner(ListNode head1, ListNode head2) {
        if (head2 != null) {
            ListNode head2Next = head2.next;
            head2.next = head1;
            return reverseList2Inner(head2, head2Next);
        } else {
            return head1;
        }
    }
}
