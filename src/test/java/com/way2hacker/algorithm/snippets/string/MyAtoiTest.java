package com.way2hacker.algorithm.snippets.string;

import org.junit.jupiter.api.Test;

/**
 * @link https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
 * @author devin
 * @date 2021/12/01 8:55 下午
 */
public class MyAtoiTest {

    @Test
    public void test() {
        String s = "  -47";
        System.out.println(myAtoi(s));
        s = "21474836460";
        System.out.println(myAtoi(s));
        s = " ";
        System.out.println(myAtoi(s));
        s = "-2147483648";
        System.out.println(myAtoi(s));
    }

    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        s = s.strip();
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }
        int result = 0;
        for (; index < length; index++) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                result = result * 10 + digit;
            }
        }
        return sign * result;

    }
}
