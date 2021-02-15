package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "Мертвые Души", 560, "Gogol", 230, 2019);
    Book book2 = new Book(2, "Война и мир", 780, "Tolstoi", 2500, 2020);
    Book book3 = new Book(3, "Собрание сочинений", 890, "Pushkin", 540, 2018);
    Book book4 = new Book(4, "Zara", 354, "NoAuthor", 257, 2015);

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
    }

    @Test
    void shouldRemoveByID() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book3, book4};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveByIdNo() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}