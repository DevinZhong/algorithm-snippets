package snippets.linkedlist;

import static snippets.linkedlist.ReserveList.reverseList;

/**
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/">https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/</a>
 * @author devin
 * @since 2021/12/13 1:24 上午
 */
public class ListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode rev = reverseList(head);
        return head != null && head.next != null && rev == head;
    }
}
