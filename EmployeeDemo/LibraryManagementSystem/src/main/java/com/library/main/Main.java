package com.library.main;

import com.library.dao.BookDAO;
import com.library.entity.Book;
import com.library.util.HibernateUtil;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BookDAO dao = new BookDAO();

        // ADD BOOKS
        dao.addBook(new Book("The Alchemist",         "Paulo Coelho",    "Fiction",  350.00, 5));
        dao.addBook(new Book("Clean Code",            "Robert Martin",   "Tech",     599.00, 3));
        dao.addBook(new Book("Atomic Habits",         "James Clear",     "Self-Help",450.00, 4));
        dao.addBook(new Book("Harry Potter",          "J.K. Rowling",    "Fantasy",  400.00, 6));
        dao.addBook(new Book("The Great Gatsby",      "F. Scott",        "Classic",  250.00, 2));

        // VIEW ALL
        List<Book> books = dao.getAllBooks();
        books.forEach(System.out::println);

        // SEARCH BY TITLE
        dao.searchByTitle("clean").forEach(System.out::println);

        // SEARCH BY AUTHOR
        dao.searchByAuthor("james").forEach(System.out::println);

        // GET BY ID
        System.out.println(dao.getById(1));

        // ISSUE BOOK
        dao.issueBook(1);
        dao.issueBook(1);

        // RETURN BOOK
        dao.returnBook(1);

        // UPDATE PRICE
        dao.updatePrice(2, 699.00);

        // DELETE
        dao.deleteBook(5);

        // FINAL LIST
        dao.getAllBooks().forEach(System.out::println);

        HibernateUtil.shutdown();
    }
}