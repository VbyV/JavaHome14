import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.statistic.JavaHome14.*;

public class ProductRepositoryTest {
    Product book1 = new Book(12, "Му-му", 500, "Иван Тургенев");
    Product book2 = new Book(10, "Harry Potter", 700, "J.Rolling");
    Product book3 = new Book(1, "Имя Розы", 670, "Умберто Эко");
    Product smartphone1 = new Smartphone(23, "galaxy5", 18_000, "Samsung");
    Product smartphone2 = new Smartphone(56, "Line", 49_000, "Xiaome");
    Product smartphone3 = new Smartphone(90, "Plus", 100_000, "Apple");

    @Test
public void CorrectRemoveByID() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(10);

        Product[] expected = {book1, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.getItems();

    }
    @Test
    public void InCorrectRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(2);
        });

    }
 }


