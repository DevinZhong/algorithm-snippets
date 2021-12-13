package snippets.string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * w和x字符串长度相同，x为数值，w为数值和?的组合
 * 求：将?替换为数值后，w字符串大于x字符串的结果有多少种
 *
 * @author devin
 * @since 2021/12/10 8:04 下午
 */
public class CountOfWLargerThanX {

    public static int count(String w, String x) {
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
    private static boolean increase(Deque<Integer> deque) {
        if (deque == null || deque.size() == 0) {
            return false;
        } else {
            int zeroCount = 0;
            while (true) {
                if (deque.size() == 0) {
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
     * @param deque     栈
     * @param zeroCount 末尾补充0的个数
     */
    private static void addZero(Deque<Integer> deque, int zeroCount) {
        while (zeroCount-- > 0) {
            deque.addLast(0);
        }
    }
}
