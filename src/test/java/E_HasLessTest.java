import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E_HasLessTest {

    int[] array = new int[] {9, 8, 7, 3, 5, -2, 6, 5,};
    int last = array.length - 1;

    @Test
    void testRightHasLess(){
        assertEquals(5, Main.rightHasLess(array, 0, 3, last));
        assertEquals(2, Main.rightHasLess(array, 0, 1, 2));
        assertEquals(-1, Main.rightHasLess(array, last - 2, last - 1, last));
        assertEquals(5, Main.rightHasLess(array, 3, 4, 5));
    }
}