package ua.opnu;

/**
 * Модель книги с подсчётом рейтинга.
 * Рейтинг = total / reviews.
 *
 * Класс реализует Comparable<BookData>:
 *  - сначала сравниваем по рейтингу по убыванию (больше рейтинг — "лучше"),
 *  - при равных рейтингах — по названию по алфавиту.
 */
public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author) {
        this.title = title;
        this.author = author;
        this.reviews = 0;
        this.total = 0.0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReviews() {
        return reviews;
    }

    public double getTotal() {
        return total;
    }

    /**
     * Текущий рейтинг книги.
     */
    public double getRating() {
        if (reviews == 0) {
            return 0.0;
        }
        return total / reviews;
    }

    /**
     * Добавить ещё одну оценку.
     */
    public void addReview(double rating) {
        if (rating < 0.0) {
            throw new IllegalArgumentException("Рейтинг не может быть отрицательным");
        }
        total += rating;
        reviews++;
    }

    @Override
    public int compareTo(BookData other) {
        // сначала по рейтингу (по убыванию)
        int byRating = Double.compare(other.getRating(), this.getRating());
        if (byRating != 0) {
            return byRating;
        }
        // при равных рейтингах — по названию по возрастанию
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", reviews=" + reviews +
                ", total=" + total +
                ", rating=" + getRating() +
                '}';
    }
}
