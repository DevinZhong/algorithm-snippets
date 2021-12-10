package snippets.string;

/**
 * @author devin
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/">https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/</a>
 * @since 2021/12/10 7:47 下午
 */
public class Atoi {

    public static int myAtoi(String s) {
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
