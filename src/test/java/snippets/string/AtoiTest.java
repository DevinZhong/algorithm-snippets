package snippets.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static snippets.string.Atoi.myAtoi;

/**
 * @author devin
 * @since 2021/12/01 8:55 下午
 */
public class AtoiTest {

    @Test
    public void test1() {
        String s = "  -47";
        Assertions.assertEquals(-47, myAtoi(s));
    }

    @Test
    public void test2() {
        String s = "21474836460";
        Assertions.assertEquals(2147483647, myAtoi(s));
    }

    @Test
    public void test3() {
        String s = " ";
        Assertions.assertEquals(0, myAtoi(s));
    }

    @Test
    public void test4() {
        String s = "-2147483648";
        Assertions.assertEquals(-2147483648, myAtoi(s));
    }

}
