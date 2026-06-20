package com.example.main;

import com.example.dao.ProductDAO;
import com.example.entity.Product;
import com.example.util.Utility;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // SAVE
        dao.save(new Product("Laptop",     "Electronics", 55000.00, 10));
        dao.save(new Product("Mouse",      "Electronics",   850.00, 50));
        dao.save(new Product("Desk Chair", "Furniture",   12000.00,  5));
        dao.save(new Product("Notebook",   "Stationery",    120.00,100));

        // GET ALL
        List<Product> list = dao.getAll();
        list.forEach(System.out::println);

        // GET BY ID
        System.out.println(dao.getById(1));

        // UPDATE
        dao.update(1, 49999.00);

        // DELETE
        dao.delete(2);

        // FINAL LIST
        dao.getAll().forEach(System.out::println);

        Utility.shutdown();
    }
}