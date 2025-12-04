package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        // Здесь можно локально что-то потестить, но для автопроверки это не обязательно.
        // Например:
        //
        // MyOptional<String> empty = new MyOptional<>();
        // System.out.println(empty);
        //
        // Integer[] nums = {1, 2, 3, 4, 5};
        // Integer[] evens = filter(nums, n -> n % 2 == 0);
        // System.out.println(Arrays.toString(evens));
    }

    /**
     * Обобщённая версия filter() из задания:
     *
     * Принимает массив объектов типа T и предикат по T,
     * возвращает новый массив только с теми элементами, для которых p.test() == true.
     */
    public static <T> T[] filter(T[] input, Predicate<? super T> p) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[input.length];
        int counter = 0;

        for (T element : input) {
            if (p.test(element)) {
                result[counter] = element;
                counter++;
            }
        }

        return Arrays.copyOf(result, counter);
    }

    /**
     * Обобщённая версия contains():
     *
     * T — тип элементов массива,
     * V — тип элемента, который ищем (V должен быть T или подтипом T).
     */
    public static <T, V extends T> boolean contains(T[] array, V element) {
        for (T value : array) {
            if (value == null && element == null) {
                return true;
            }
            if (value != null && value.equals(element)) {
                return true;
            }
        }
        return false;
    }
}
