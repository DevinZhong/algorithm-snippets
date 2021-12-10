package snippets.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 在字符串中统计连续出现2个a和连续出现2个b的个数，
 * 连续出现3个a和3个b等，不计数
 *
 * @author devin
 * @since 2021/12/10 7:55 下午
 */
public class CountOfAaBb {

    public static int count(String text) {
        int aCount = 0;
        int bCount = 0;
        int totalCount = 0;
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == 'a') {
                aCount++;
            } else {
                if (aCount == 2) {
                    totalCount++;
                }
                aCount = 0;
            }
            if (c == 'b') {
                bCount++;
            } else {
                if (bCount == 2) {
                    totalCount++;
                }
                bCount = 0;
            }
        }
        if (aCount == 2 || bCount == 2) {
            totalCount++;
        }
        return totalCount;
    }

    public static int countByRegExp(String text) {
        int count = 0;
        Pattern aPattern = Pattern.compile("([^a]|\\b)aa([^a]|\\b)");
        Matcher aMatcher = aPattern.matcher(text);
        while (aMatcher.find()) {
            String sub = text.substring(aMatcher.start(), aMatcher.end());
            count++;
        }
        Pattern bPattern = Pattern.compile("([^b]|\\b)bb([^b]|\\b)");
        Matcher bMatcher = bPattern.matcher(text);
        while (bMatcher.find()) {
            String sub = text.substring(bMatcher.start(), bMatcher.end());
            count++;
        }
        return count;
    }
}
