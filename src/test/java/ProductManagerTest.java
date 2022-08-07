import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.ProductRepository;
import ru.netology.domain.ProductManager;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);
    Book book1 = new Book(001, "My secret", 450, "Ivanov");
    Book book2 = new Book(002, "Your secret", 600, "Petrov");
    Smartphone smartphone1 = new Smartphone(003, "Galaxy", 40_000, "Samsung");
    Smartphone smartphone2 = new Smartphone(004, "IPhone", 80_000, "Apple");

    @Test
    public void testAdd() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSecondElements() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("sec");
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFirstElement() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNull() {

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("cac");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind0Because0Added() {

        Product[] actual = manager.searchBy("sec");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}