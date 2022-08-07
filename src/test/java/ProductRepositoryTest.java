import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.ProductRepository;
import ru.netology.domain.Smartphone;


public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Book book1 = new Book(001, "My secret", 450, "Ivanov");
    Book book2 = new Book(002, "Your secret", 600, "Petrov");
    Smartphone smartphone1 = new Smartphone(003, "Galaxy", 40_000, "Samsung");
    Smartphone smartphone2 = new Smartphone(004, "IPhone", 80_000, "Apple");

    @Test
    public void testAdd() {

        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemove() {

        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);

        Product[] actual = repo.removeById(1);
        Product[] expected = {book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }
}

