import ru.netology.domain.Book;
import ru.netology.domain.ProductManager;
import ru.netology.domain.ProductRepository;
import ru.netology.domain.Smartphone;

public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(new Book(001, "My secret", 450, "Ivanov"));
        manager.add(new Book(002, "Your secret", 600, "Petrov"));
        manager.add(new Smartphone(003, "Galaxy", 40_000, "Samsung"));
        manager.add(new Smartphone(004, "IPhone", 80_000, "Apple"));

        manager.searchBy("sec");
    }
}
