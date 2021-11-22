package com.way2hacker.algorithm.snippets.string;

import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * w和x字符串长度相同，x为数值，w为数值和?的组合
 * 求：将?替换为数值后，w字符串大于x字符串的结果有多少种
 *
 * @author devin
 * @date 2021/11/21 8:37 下午
 */
public class StringStatistics2Test {
    private int count(String w, String x) {
        System.out.println(w + ":" + x);
        char[] wChars = w.toCharArray();
        char[] xChars = x.toCharArray();
        int questionCount = Long.valueOf(IntStream.range(0, wChars.length)
                .mapToObj(i -> wChars[i])
                .filter(c -> c == '?')
                .count()).intValue();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < wChars.length; i++) {
            if (wChars[i] == '?') {
                stack.addLast(Character.getNumericValue(xChars[i]));
                if (i == wChars.length - 1) {
                    if (!increase(stack)) {
                        return 0;
                    }
                }
            } else if (wChars[i] > xChars[i]) {
                addZero(stack, questionCount - stack.size());
                break;
            } else if (wChars[i] < xChars[i]
                    || (wChars[i] == xChars[i] && i == wChars.length - 1)) {
                if (stack.size() > 0) {
                    if (!increase(stack)) {
                        return 0;
                    }
                    addZero(stack, questionCount - stack.size());
                    break;
                } else {
                    return 0;
                }
            }
        }
        return Double.valueOf(Math.pow(10, stack.size())).intValue() - Integer.parseInt(stack.stream().map(String::valueOf).collect(Collectors.joining()));
    }

    /**
     * 加一操作，位数不变
     * 如果栈为空，返回false
     * 每一位加一后为10，向高位进一
     * 如果最高位也需要向前进位，返回false
     *
     * @param deque deque栈
     * @return 成功返回true，失败返回false
     */
    private boolean increase(Deque<Integer> deque) {
        if (CollectionUtils.isEmpty(deque)) {
            return false;
        } else {
            int zeroCount = 0;
            while (true) {
                if (CollectionUtils.isEmpty(deque)) {
                    return false;
                }
                int lastValue = deque.removeLast();
                lastValue++;
                if (lastValue == 10) {
                    zeroCount++;
                } else {
                    deque.addLast(lastValue);
                    break;
                }
            }
            while (zeroCount-- > 0) {
                deque.addLast(0);
            }
            return true;
        }
    }

    /**
     * 栈后面补0
     *
     * @param deque 栈
     * @param zeroCount 末尾补充0的个数
     */
    private void addZero(Deque<Integer> deque, int zeroCount) {
        while (zeroCount-- > 0) {
            deque.addLast(0);
        }
    }

    @Test
    public void test() {
        String w = "?";
        String x = "4";
        int count = count(w, x);
        assert count == 5;

        w = "??";
        x = "47";
        count = count(w, x);
        assert count == 52;

        w = "??";
        x = "89";
        count = count(w, x);
        assert count == 10;

        w = "??";
        x = "99";
        count = count(w, x);
        assert count == 0;

        w = "?3?";
        x = "447";
        count = count(w, x);
        assert count == 50;

        w = "?47";
        x = "447";
        count = count(w, x);
        assert count == 5;

        w = "3?3?";
        x = "5447";
        count = count(w, x);
        assert count == 0;

        w = "192?32432??2342??333?";
        x = "192472482442342243330";
        count = count(w, x);
        assert count == 500000;
    }
}
