import java.io.UnsupportedEncodingException;
import java.util.PrimitiveIterator;
import java.util.Random;

public class Main {
    static final int MIN_BOUND_VALUE = 0;
    static final  int MAX_BOUND_VALUE = Integer.MAX_VALUE/2;
    static final int MIN_VALUE = -100;
    static final int MAX_VALUE = 100;
    static final int ARRAY_LENGTH = 10;
    private static final PrimitiveIterator.OfInt randomIntsGenerator =
            new Random().ints(MIN_VALUE,MAX_VALUE ).iterator();

    public static void main(String[] args) {
       int[] array = new int[ARRAY_LENGTH];
       System.out.print("исходный массив: ");
       for (int i = 0; i < array.length; i++) {
           array[i] = randomIntsGenerator.nextInt();
           System.out.print(array[i] + " ");
       }
        System.out.println();
    }

    public static int getMiddle(int from, int to) {
        if (from < MIN_BOUND_VALUE) throw new ArithmeticException("Меньший индекс не может быть меньше 0");
        if (to > MAX_BOUND_VALUE) throw new ArithmeticException("Недопустить перерасход памяти");
        if (!(from < to)) throw new ArithmeticException("Начальный индекс должен быть меньше конечного");
        double length = to + from;
        double middle = Math.floor(length / 2);
        return (int)middle;
    }
}
