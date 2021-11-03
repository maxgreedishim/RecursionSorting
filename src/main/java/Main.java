import java.io.UnsupportedEncodingException;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class Main {
    static final int MIN_BOUND_VALUE = 0;
    static final  int MAX_BOUND_VALUE = Integer.MAX_VALUE/2;
    static final int MIN_VALUE = -100;
    static final int MAX_VALUE = 100;
    static final int ARRAY_LENGTH = 8;
    static final int solution = 4;
    private static final PrimitiveIterator.OfInt randomIntsGenerator =
            new Random().ints(MIN_VALUE,MAX_VALUE ).iterator();


    /*public static void main(String[] args) {
       int[] array = new int[ARRAY_LENGTH];
       System.out.print("исходный массив: ");
       for (int i = 0; i < array.length; i++) {
           array[i] = randomIntsGenerator.nextInt();
           System.out.print(array[i] + " ");
       }
        System.out.println();

    }*/
    public static void main(String[] args) {
        int[] array = new int[ARRAY_LENGTH];
        for(int i = 0; i < array.length; i++) array[i] = randomIntsGenerator.nextInt();
        printArray(array, "     исходное состояние массива");

        sort(array, 0, array.length - 1);
        printArray(array, "         отсортированный массив");
    }
    static int rightHasLess(int[] array, int from, int middle, int to){
        int min = array[from];
        for(int i = from + 1; i <= to; i++) {
            if(array[i] >= min) continue;
            if(i > middle) return i;
            min = array[i];
        }
        return -1;
    }
    static void swap(int[] array, int from, int middle, int to, boolean recursive){
        int min = array[from];
        for(int i = from + 1; i <= middle; i++) {
            min = Math.min(array[i], min);
        }
        int indexOfLess = -1;
        for(int i = middle + 1; i <= to; i++){
            if(array[i] >= min) continue;
            indexOfLess = i;
            break;
        }
        if(indexOfLess == -1) return;
        int tmp = array[indexOfLess];
        array[indexOfLess] = array[middle];
        array[middle] = tmp;
        if(recursive) sort(array, from, to);
        printArray(array, "промежуточное состояние массива");
    }
    public static void sort(int[] array, int from, int to){

        if(!(from < to)) return;
        int middle = getMiddle(from, to);
        sort(array, from, middle);
        sort(array, middle + 1, to);
        merge(array, from, middle, to);
    }

    static void merge(int[] array, int from, int middle, int to){
        swapRecursive(array, from, middle, to);
    }
    static void printArray(int[] array, String description){
        System.out.print(description + ": ");
        for (int i : array) System.out.print(i + " ");
        System.out.println();
    }
    static void swapRecursive(int[] array, int from, int middle, int to){
        swap(array, from, middle, to, true);
    }

    public static int getMiddle(int from, int to) {
        if (from < MIN_BOUND_VALUE) throw new ArithmeticException("Меньший индекс не может быть меньше 0");
        if (to > MAX_BOUND_VALUE) throw new ArithmeticException("Недопустить перерасход памяти");
        if (!(from < to)) throw new ArithmeticException("Начальный индекс должен быть меньше конечного");
        double length = to + from;
        double middle = Math.floor(length / 2);
        return (int)middle;
    }

   //Напишите числа a и b, сумма которых будет равна 4
    public static int getArithmeticСheck(int a, int b) {
        if (a < 0 || b < 0) throw new ArithmeticException("Слагаемое не может быть меньше 0 ");
        if (a + b != solution) throw new ArithmeticException("В сумме должно получится 4");
        return a + b;
    }
}
