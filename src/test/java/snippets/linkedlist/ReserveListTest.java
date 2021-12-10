package snippets.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author devin
 * @since 2021/12/10 8:57 下午
 */
public class ReserveListTest {

    @Test
    public void test1() {
        ListNode head = ListNode.fromArray(new int[] {1, 2, 3, 4, 5});
        head = ReserveList.reverseList(head);
        Assertions.assertEquals("[5, 4, 3, 2, 1]", Arrays.toString(head.toArray()));
    }

    @Test
    public void test2() {
        ListNode head = ListNode.fromArray(new int[] {1, 2, 3, 4, 5});
        head = ReserveList.reverseList2(head);
        Assertions.assertEquals("[5, 4, 3, 2, 1]", Arrays.toString(head.toArray()));
    }
}
