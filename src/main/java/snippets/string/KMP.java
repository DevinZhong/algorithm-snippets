package snippets.string;

/**
 * @author devin
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/">https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/</a>
 * @since 2021/12/10 7:40 下午
 */
public class KMP {

    public static int strStr(String haystack, String needle) {
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
     * @param pattern 模式字符串
     * @return 模式串对应的 next 数组
     */
    private static int[] getNext(String pattern) {
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
