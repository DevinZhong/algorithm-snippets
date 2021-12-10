package snippets.linkedlist;

/**
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
}
