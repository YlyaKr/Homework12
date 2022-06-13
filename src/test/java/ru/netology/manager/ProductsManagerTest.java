package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductsRepository;

public class ProductsManagerTest {
    Book book1 = new Book(1, "Ulyssesung123", 700, "James Joyce");
    Smartphone smartphone1 = new Smartphone(2, "Samsung", 20000, "Samsung123");
    Book book2 = new Book(3, "The Invisible Man1", 800, "Herbert Wells123");


    @Test
    public void test() {
        ProductsRepository repository = new ProductsRepository();
        ProductsManager manager = new ProductsManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] actual = manager.searchBy("123");
        Product[] expected = {book1, smartphone1, book2};

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSearchByTwoElements() {
        ProductsRepository repository = new ProductsRepository();
        ProductsManager manager = new ProductsManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] actual = manager.searchBy("ung");
        Product[] expected = {book1, smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByNoElement() {
        ProductsRepository repository = new ProductsRepository();
        ProductsManager manager = new ProductsManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] actual = manager.searchBy("out");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByAllElements() {
        ProductsRepository repository = new ProductsRepository();
        ProductsManager manager = new ProductsManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] actual = manager.searchBy("n");
        Product[] expected = {book1, smartphone1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAll() {
        ProductsRepository repository = new ProductsRepository();
        ProductsManager manager = new ProductsManager(repository);

        manager.add(book1);
        manager.add(book2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveElement() {
        ProductsRepository repository = new ProductsRepository();
        ProductsManager manager = new ProductsManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        repository.removeById(1);

        Product[] actual = repository.findAll();
        Product[] expected = {smartphone1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }
}
