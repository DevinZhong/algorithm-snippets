package snippets.array;

/**
 * @author devin
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/">https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/</a>
 * @since 2021/12/10 6:13 下午
 */
public class ArrayRotate {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        int index = nums.length - k;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[index++];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
