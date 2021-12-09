package com.way2hacker.algorithm.snippets.string;

import org.junit.jupiter.api.Test;

/**
 * @link https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
 * @author devin
 * @date 2021/12/08 2:22 下午
 */
public class KMPTest {

    @Test
    public void test() {

        var str = "ababcaababcaabc";
        var pattern = "ababcaabc";
        var index = strStr(str, pattern);
        System.out.println(str + " -> " + pattern + " = " + index);

        str = "hello";
        pattern = "ll";
        index = strStr(str, pattern);
        System.out.println(str + " -> " + pattern + " = " + index);

        str = "";
        pattern = "";
        index = strStr(str, pattern);
        System.out.println(str + " -> " + pattern + " = " + index);

        str = "aaa";
        pattern = "aaa";
        index = strStr(str, pattern);
        System.out.println(str + " -> " + pattern + " = " + index);


    }

    public int strStr(String haystack, String needle) {
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        if (needles.length == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while (i < haystacks.length - needles.length + j + 1) {
            if (j == -1 || haystacks[i] == needles[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == needles.length) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * 构建 next[0] 为 -1 的 next 数组
     *
     * @param pattern
     * @return
     */
    private int[] getNext(String pattern) {
        int length = pattern.length();
        int[] next = new int[length];
        next[0] = -1;
        int i = 1;
        int j = next[i - 1];
        while (i < length) {
            if (j == -1 || pattern.charAt(i - 1) == pattern.charAt(j)) {
                next[i++] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
