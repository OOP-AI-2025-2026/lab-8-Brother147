package ua.opnu;

/**
 * Упрощённый аналог java.util.Optional<T>.
 */
public class MyOptional<T> {

    private final T value;
    private final boolean present;

    /**
     * Пустой конструктор — создаёт "порожнее" значение.
     */
    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    /**
     * Конструктор со значением.
     * @throws IllegalArgumentException если value == null
     */
    public MyOptional(T value) {
        if (value == null) {
            // формулировка из README
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    /**
     * Есть ли значение внутри.
     */
    public boolean isPresent() {
        return present;
    }

    /**
     * Пустой ли объект.
     */
    public boolean isEmpty() {
        return !present;
    }

    /**
     * Получить значение, если оно есть.
     * @throws IllegalStateException если значение отсутствует
     */
    public T get() {
        if (!present) {
            throw new IllegalStateException("Значення відсутнє");
        }
        return value;
    }

    /**
     * Вернуть значение или значение по умолчанию, если его нет.
     */
    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        }
        return "MyOptional[empty]";
    }
}
