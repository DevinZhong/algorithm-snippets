package snippets.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author devin
 * @since 2021/11/21 8:37 下午
 */
public class CountOfWLargerThanXTest {

    @Test
    public void test1() {
        String w = "?";
        String x = "4";
        int count = CountOfWLargerThanX.count(w, x);
        Assertions.assertEquals(5, count);
    }

    @Test
    public void test2() {
        String w = "??";
        String x = "47";
        int count = CountOfWLargerThanX.count(w, x);
        Assertions.assertEquals(52, count);
    }

    @Test
    public void test3() {
        String w = "??";
        String x = "89";
        int count = CountOfWLargerThanX.count(w, x);
        Assertions.assertEquals(10, count);
    }

    @Test
    public void test4() {
        String w = "??";
        String x = "99";
        int count = CountOfWLargerThanX.count(w, x);
        Assertions.assertEquals(0, count);
    }

    @Test
    public void test5() {
        String w = "?3?";
        String x = "447";
        int count = CountOfWLargerThanX.count(w, x);
        Assertions.assertEquals(50, count);
    }

    @Test
    public void test6() {
        String w = "?47";
        String x = "447";
        int count = CountOfWLargerThanX.count(w, x);
        Assertions.assertEquals(5, count);
    }

    @Test
    public void test7() {
        String w = "3?3?";
        String x = "5447";
        int count = CountOfWLargerThanX.count(w, x);
        Assertions.assertEquals(0, count);
    }

    @Test
    public void test8() {
        String w = "192?32432??2342??333?";
        String x = "192472482442342243330";
        int count = CountOfWLargerThanX.count(w, x);
        Assertions.assertEquals(500000, count);
    }
}
