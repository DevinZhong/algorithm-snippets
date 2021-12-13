package snippets.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author devin
 * @since 2021/12/13 1:26 上午
 */
public class ListCycleTest {

    private ListCycle listCycle = new ListCycle();

    @Test
    public void test1() {
        ListNode head = ListNode.fromArray(new int[] {3, 2, 0, -4}, 1);
        Assertions.assertTrue(listCycle.hasCycle(head));
    }

    @Test
    public void test2() {
        ListNode head = ListNode.fromArray(new int[] {1}, -1);
        Assertions.assertFalse(listCycle.hasCycle(head));
    }

    @Test
    public void test3() {
        ListNode head = ListNode.fromArray(new int[] {1, 2}, -1);
        Assertions.assertFalse(listCycle.hasCycle(head));
    }

    @Test
    public void test4() {
        ListNode head = ListNode.fromArray(new int[] {3}, 0);
        Assertions.assertTrue(listCycle.hasCycle2(head));
    }
}
