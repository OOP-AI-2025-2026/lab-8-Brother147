package ua.opnu;

/**
 * Класс для печати элементов массива.
 */
public class Printer {

    /**
     * Обобщённый метод, печатающий элементы массива любого ссылочного типа.
     */
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
