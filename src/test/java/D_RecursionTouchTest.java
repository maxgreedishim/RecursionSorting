import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class D_RecursionTouchTest {

    int zero = 0;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    @DisplayName("Сколько раз начиналась рекурсия (алг.):")
    void checkCountsOutAlgorithmically(int length){
        //System.out.println(length);
        int[] expected = switch(length){
            case 1  -> new int[] {0};
            case 2  -> new int[] {1, 1};
            case 3  -> new int[] {2, 2, 1};
            case 4  -> new int[] {2, 2, 2, 2};
            case 5  -> new int[] {3, 3, 2, 2, 2};
            case 6  -> new int[] {3, 3, 2, 3, 3, 2};
            case 7  -> new int[] {3, 3, 3, 3, 3, 3, 2};
            case 8  -> new int[] {3, 3, 3, 3, 3, 3, 3, 3};
            case 9  -> new int[] {4, 4, 3, 3, 3, 3, 3, 3, 3};
            case 10 -> new int[] {4, 4, 3, 3, 3, 4, 4, 3, 3, 3};
            default -> throw new IllegalStateException("Unexpected length: " + length);
        };
        int[] test = new int[length];
        int last = length - 1;
        touch(test, zero, last);
        assertArrayEquals(expected, test);
    }

    private void touch(int[] array, int from, int to){
        if(!(from < to)) return;
        int middle = Main.getMiddle(from, to);
        touch(array, from, middle);
        touch(array, middle + 1, to);
        increment(array, from, to); // сам массив
    }

    private void increment(int[] array, int from, int to){
        for(int i = from; i <= to;  i++) array[i] += 1;
    }
}