package snippets.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author devin
 * @since 2021/12/11 5:37 下午
 */
public class MergeSortedListTest {

    @Test
    public void test1() {
        ListNode head1 = ListNode.fromArray(new int[]{1, 3, 3, 4, 9});
        ListNode head2 = ListNode.fromArray(new int[]{-1, 4, 4, 4, 7, 10});
        Assertions.assertEquals("[-1, 1, 3, 3, 4, 4, 4, 4, 7, 9, 10]", Arrays.toString(MergeSortedList.mergeTwoLists(head1, head2).toArray()));
    }
}
