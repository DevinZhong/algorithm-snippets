package snippets.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author devin
 * @since 2021/12/13 11:20 上午
 */
public class PalindromeListTest {

    private final PalindromeList palindromeList = new PalindromeList();

    @Test
    public void test1() {
        ListNode head = ListNode.fromArray(new int[] {3, 2, 2, 3});
        Assertions.assertTrue(palindromeList.isPalindrome(head));
    }

    @Test
    public void test2() {
        ListNode head = ListNode.fromArray(new int[] {3, 2, 2, 3});
        Assertions.assertTrue(palindromeList.isPalindrome2(head));
    }

}
