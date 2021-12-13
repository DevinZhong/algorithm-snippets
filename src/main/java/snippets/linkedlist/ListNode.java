package snippets.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author devin
 * @since 2021/12/10 8:54 下午
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 将自身及后续节点转换成数组
     * 一般仅仅头节点使用
     *
     * @return 转换成的数组
     */
    public int[] toArray() {
        List<Integer> list = new ArrayList<>();
        ListNode tempNode = this;
        do {
            list.add(tempNode.val);
            tempNode = tempNode.next;
        } while (tempNode != null);
        return list.stream().mapToInt(i->i).toArray();
    }

    /**
     * 将数组转换成链表，便于测试
     * 工厂方法
     *
     * @param array 要转换成链表的数组
     * @return 生成的链表的头节点
     */
    public static ListNode fromArray(int[] array) {
        return fromArray(array, -1);
    }

    public static ListNode fromArray(int[] array, int pos) {
        ListNode dummy = new ListNode(array[0]);
        ListNode curr = dummy;
        List<ListNode> list = new ArrayList<>();
        for (int item : array) {
            curr.next = new ListNode(item);
            list.add(curr.next);
            curr = curr.next;
        }
        if (pos != -1) {
            curr.next = list.get(pos);
        }
        return dummy.next;
    }
}
