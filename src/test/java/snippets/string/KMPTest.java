package snippets.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author devin
 * @since 2021/12/08 2:22 下午
 */
public class KMPTest {

    @Test
    public void test1() {

        var str = "ababcaababcaabc";
        var pattern = "ababcaabc";
        var index = KMP.strStr(str, pattern);
        Assertions.assertEquals(6, index);

    }

    @Test
    public void test2() {
        var str = "hello";
        var pattern = "ll";
        var index = KMP.strStr(str, pattern);
        Assertions.assertEquals(2, index);
    }

    @Test
    public void test3() {
        var str = "";
        var pattern = "";
        var index = KMP.strStr(str, pattern);
        Assertions.assertEquals(0, index);
    }

    @Test
    public void test4() {
        var str = "aaa";
        var pattern = "aaa";
        var index = KMP.strStr(str, pattern);
        Assertions.assertEquals(0, index);
    }
}
