package com.way2hacker.algorithm.snippets.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @link https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * @author devin
 * @date 2021/11/29 11:46 下午
 */
public class ArrayRotate1Test {

    @Test
    public void test() {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println(Arrays.toString(nums));
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
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
