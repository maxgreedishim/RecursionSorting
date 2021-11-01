import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.PrimitiveIterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Main class testing")
public class MainTest {

    private static final PrimitiveIterator.OfInt randomIntsGenerator =
            new Random().ints(Main.MIN_BOUND_VALUE, Main.MAX_BOUND_VALUE).iterator();

    @Test
    void checkExtremalSituations(){
        assertThrows(ArithmeticException.class,()-> Main.getMiddle(-1,1000));
        assertThrows(ArithmeticException.class,()-> Main.getMiddle(0,Integer.MAX_VALUE));
        assertThrows(ArithmeticException.class,()-> Main.getMiddle(10,10));
        assertThrows(ArithmeticException.class,()-> Main.getMiddle(20,10));
    }


    @RepeatedTest(10000)
    @DisplayName("Check the middle.")
    void checkTheMiddle(){
        int from = randomIntsGenerator.nextInt();
        int to = randomIntsGenerator.nextInt();
        while (!(from < to)) {
            to = randomIntsGenerator.nextInt();
            from = randomIntsGenerator.nextInt();
        }
        int middle = Main.getMiddle(from,to);
        assertTrue(middle >= from && middle < to);
    }

    @Test
    @DisplayName("Simple arephmetic")
    void test() {
        assertTrue (2 * 2 == 4);
        assertEquals(4,2 * 2);
    }
}
