package snippets.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import snippets.array.ArrayIntersect;

import java.util.Arrays;

/**
 * @author devin
 * @since 2021/11/30 10:46 下午
 */
public class ArrayIntersectTest {

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        Assertions.assertEquals("[2, 2]", Arrays.toString(ArrayIntersect.intersect(nums1, nums2)));
    }
}
