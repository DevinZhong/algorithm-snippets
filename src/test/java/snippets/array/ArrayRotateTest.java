package snippets.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author devin
 * @since 2021/11/29 11:46 下午
 */
public class ArrayRotateTest {

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        ArrayRotate.rotate(nums, k);
        Assertions.assertEquals("[5, 6, 7, 1, 2, 3, 4]", Arrays.toString(nums));
    }

}
