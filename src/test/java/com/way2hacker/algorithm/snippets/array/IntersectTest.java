package com.way2hacker.algorithm.snippets.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @link https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * @author devin
 * @date 2021/11/30 10:46 下午
 */
public class IntersectTest {

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        sort(nums1);
        sort(nums2);
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

    private void sort(int[] nums) {
        Arrays.sort(nums);
    }
}
