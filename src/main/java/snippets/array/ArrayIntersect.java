package snippets.array;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/">https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/</a>
 * @author devin
 * @since 2021/12/10 7:06 下午
 */
public class ArrayIntersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] shortNums, longNums;
        if (nums1.length > nums2.length) {
            shortNums = nums2;
            longNums = nums1;
        } else {
            shortNums = nums1;
            longNums = nums2;
        }
        int i = 0;
        int j = 0;
        int[] temp = new int[shortNums.length];
        int index = 0;
        while (i < shortNums.length && j < longNums.length) {
            if (shortNums[i] < longNums[j]) {
                i++;
            } else if (shortNums[i] > longNums[j]) {
                j++;
            } else {
                temp[index++] = shortNums[i];
                i++;
                j++;
            }
        }
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        return result;
    }
}
