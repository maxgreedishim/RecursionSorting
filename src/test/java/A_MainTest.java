import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.PrimitiveIterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тестирование программы")
public class A_MainTest {

    private static final PrimitiveIterator.OfInt randomIntsGenerator =
            new Random().ints(Main.MIN_BOUND_VALUE, Main.MAX_BOUND_VALUE).iterator();

    @Test
    @DisplayName("Тест на экстримальные ситуации")
    void checkExtremalSituations(){
        assertThrows(ArithmeticException.class,()-> Main.getMiddle(-1,1000));
        assertThrows(ArithmeticException.class,()-> Main.getMiddle(0,Integer.MAX_VALUE));
        assertThrows(ArithmeticException.class,()-> Main.getMiddle(10,10));
        assertThrows(ArithmeticException.class,()-> Main.getMiddle(20,10));
    }

    @RepeatedTest(5)
    @DisplayName("Проверка серидины")
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

    @RepeatedTest(500)
    @DisplayName("Проверка на правильность слагаемых")
    void arithmeticСheck() {
       assertThrows(ArithmeticException.class,()-> Main.getArithmeticСheck(randomIntsGenerator.nextInt(), randomIntsGenerator.nextInt()));
       }
    @RepeatedTest(1)
    @DisplayName("Проверка на правильность ответа")
    void arithmeticСheckSumma(){
        final int a = randomIntsGenerator.nextInt();
        final int b = randomIntsGenerator.nextInt() + 20;
        assertThrows(ArithmeticException.class,() -> Main.getArithmeticСheck(a, b));

    }
}
