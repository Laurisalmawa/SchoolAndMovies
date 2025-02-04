package arrays;

import array.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {

    BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void whenEnterAnArrayThenSortIt() {
        int[] numbers = new int[] {6,7,3,4};
        int[] result = bubbleSort.sort(numbers);
        int[] expected = new int[] {3,4,6,7};

        Assertions.assertArrayEquals(expected, result);

        System.out.println(Arrays.toString(result));
    }
}
