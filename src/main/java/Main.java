import java.io.UnsupportedEncodingException;
import java.util.Arrays;
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


    public static void main(String[] args) {
        int[] array = new int[ARRAY_LENGTH];
        for(int i = 0; i < array.length; i++)
            array[i] = randomIntsGenerator.nextInt();
        printArray(array, "     исходное состояние массива");
        quickSort(array, 0, array.length -1);
        System.out.println("Стало");
        System.out.println(Arrays.toString(array));
        //printArray(array, "половина массива ");
        //sort(array, 0, array.length - 1 );
        //printArray(array, "         отсортированный массив");

    }
    public static void quickSort(int[] array, int from, int to) {
        int middle = from + (to - from) / 2;
        int opora = array[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        while (from <= to) {
            while (array[from] < opora) {
                from++;
            }

            while (array[to] > opora) {
                to--;
            }

            if (from <= to) {//меняем местами
                int temp = array[from];
                array[from] = array[to];
                array[to] = temp;
                from++;
                to--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части

        System.out.println("маркер:" + middle);
        sort(array, from, middle);
        sort(array, middle + 1, to);
        merge(array, from, middle, to);
    }


    public static void swap(int[] array, int from, int middle, int to, boolean recursive){

        int min = array[from];
        System.out.println("Значения min:" + min);

        int indexOfLess = -1;
        for(int i = middle + 1; i <= to; i++){
            if(array[i] >= min) continue;
            indexOfLess = i;
            System.out.println("индекс i: " + i);
            break;
        }
        if(indexOfLess == -1) return;
        int tmp = array[indexOfLess];
        array[indexOfLess] = array[middle];
        array[middle] = tmp;
        System.out.println("tmp: " + tmp);
        if(recursive) sort(array, from, to);
        printArray(array, "промежуточное состояние массива");

    }
    public static void sort(int[] array, int from, int to){

        if(!(from < to)) return;
        //int middle = getMiddle(from, to);
        int middle = from;
        System.out.println("маркер:" + middle);
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
        double middle = from;
        return (int) middle;
    }

   //Напишите числа a и b, сумма которых будет равна 4
    public static int getArithmeticСheck(int a, int b) {
        if (a < 0 || b < 0) throw new ArithmeticException("Слагаемое не может быть меньше 0 ");
        if (a + b != solution) throw new ArithmeticException("В сумме должно получится 4");
        return a + b;
    }
}
