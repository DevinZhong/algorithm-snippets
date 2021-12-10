package snippets.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author devin
 * @since 2021/11/21 12:49 下午
 */
public class CountOfAaBbTest {

    @Test
    public void test1() {
        String text1 = "aabbccddbbbbbaae";
        int count = CountOfAaBb.count(text1);
        Assertions.assertEquals(3, count);
    }

    @Test
    public void test2() {
        String text1 = "aabbccddbbbbbaae";
        int count = CountOfAaBb.countByRegExp(text1);
        Assertions.assertEquals(3, count);
    }
}
