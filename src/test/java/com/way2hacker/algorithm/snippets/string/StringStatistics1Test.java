package com.way2hacker.algorithm.snippets.string;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author devin
 * @date 2021/11/21 12:49 下午
 */
public class StringStatistics1Test {

    private static int count1(String text) {
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

    private int count2(String text) {
        int count = 0;
        Pattern aPattern = Pattern.compile("([^a]|\\b)aa([^a]|\\b)");
        Matcher aMatcher = aPattern.matcher(text);
        while(aMatcher.find()) {
            String sub = text.substring(aMatcher.start(), aMatcher.end());
            System.out.println(aMatcher.start() + ":" + aMatcher.end() + ":" + sub);
            count++;
        }
        Pattern bPattern = Pattern.compile("([^b]|\\b)bb([^b]|\\b)");
        Matcher bMatcher = bPattern.matcher(text);
        while (bMatcher.find()) {
            String sub = text.substring(bMatcher.start(), bMatcher.end());
            System.out.println(bMatcher.start() + ":" + bMatcher.end() + ":" + sub);
            count++;
        }
        return count;
    }

    @Test
    public void test1() {
        String text1 = "aabbccddbbbbbaae";
        int count = count1(text1);
        assert count == 3;
    }

    @Test
    public void test2() {
        String text1 = "aabbccddbbbbbaae";
        int count = count2(text1);
        assert count == 3;
    }
}
