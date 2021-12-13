package snippets.linkedlist;

/**
 * @author devin
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/">https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/</a>
 * @since 2021/12/13 11:14 上午
 */
public class PalindromeList {

    public ListNode temp;

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = ReserveList.reverseList(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        temp = head;
        return check(head);
    }

    public boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = check(head.next) && (head.val == temp.val);
        temp = temp.next;
        return res;
    }
}
