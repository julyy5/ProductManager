import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {
    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Унесённые ветром", 1000, "Маргарет Митчелл");
    Product book2 = new Book(51, "Преступление и наказание", 1500, "Ф.М. Достоевский");
    Product book3 = new Book(39, "Три товарища", 750, "Э.М. Ремарк");
    Product book4 = new Book(45, "Старик и море", 1000, "Эрнест Хемингуэй");
    Product smartPhone1 = new SmartPhone(52, "Samsung", 45000, "Korea");
    Product smartPhone2 = new SmartPhone(68, "iPhone", 70000, "USA");
    Product smartPhone3 = new SmartPhone(77, "Xiaomi", 30000, "China");


    @Test
    public void search1Product() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartPhone1);
        manager.addProduct(smartPhone2);
        manager.addProduct(smartPhone3);
        Product[] actual = manager.searchBy("Три товарища");
        Product[] expected = {book3};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchMore1Product() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartPhone1);
        manager.addProduct(smartPhone2);
        manager.addProduct(smartPhone3);
        Product[] actual = manager.searchBy("и");
        Product[] expected = {book2, book3, book4};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void removeForId() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartPhone1);
        manager.addProduct(smartPhone2);
        manager.addProduct(smartPhone3);
        Product[] actual = manager.remove(52);
        Product[] expected = {book1, book2, book3, book4, smartPhone2, smartPhone3};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void FindAllProduct() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartPhone1);
        manager.addProduct(smartPhone2);
        manager.addProduct(smartPhone3);
        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, book4, smartPhone1, smartPhone2, smartPhone3};
        Assertions.assertArrayEquals(expected, actual);

    }


}
