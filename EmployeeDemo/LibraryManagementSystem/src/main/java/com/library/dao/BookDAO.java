package com.library.dao;

import com.library.entity.Book;
import com.library.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BookDAO {

    // ADD BOOK
    public void addBook(Book b) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx  = session.beginTransaction();
        try {
            session.persist(b);
            tx.commit();
            System.out.println("Book added: " + b.getTitle());
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // VIEW ALL BOOKS
    public List<Book> getAllBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("FROM Book", Book.class).list();
        } finally {
            session.close();
        }
    }

    // SEARCH BY ID
    public Book getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Book.class, id);
        } finally {
            session.close();
        }
    }

    // SEARCH BY TITLE
    public List<Book> searchByTitle(String keyword) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery(
                            "FROM Book WHERE title LIKE :kw", Book.class)
                    .setParameter("kw", "%" + keyword + "%")
                    .list();
        } finally {
            session.close();
        }
    }

    // SEARCH BY AUTHOR
    public List<Book> searchByAuthor(String author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery(
                            "FROM Book WHERE author LIKE :a", Book.class)
                    .setParameter("a", "%" + author + "%")
                    .list();
        } finally {
            session.close();
        }
    }

    // ISSUE BOOK
    public void issueBook(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx  = session.beginTransaction();
        try {
            Book b = session.get(Book.class, id);
            if (b != null && b.getAvailable() > 0) {
                b.setAvailable(b.getAvailable() - 1);
                session.merge(b);
                tx.commit();
                System.out.println("Book issued: " + b.getTitle()
                        + " | Remaining: " + b.getAvailable());
            } else {
                System.out.println("Book not available!");
                tx.rollback();
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // RETURN BOOK
    public void returnBook(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx  = session.beginTransaction();
        try {
            Book b = session.get(Book.class, id);
            if (b != null && b.getAvailable() < b.getQuantity()) {
                b.setAvailable(b.getAvailable() + 1);
                session.merge(b);
                tx.commit();
                System.out.println("Book returned: " + b.getTitle()
                        + " | Available: " + b.getAvailable());
            } else {
                System.out.println("All copies already in library!");
                tx.rollback();
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // UPDATE PRICE
    public void updatePrice(int id, double newPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx  = session.beginTransaction();
        try {
            Book b = session.get(Book.class, id);
            if (b != null) {
                b.setPrice(newPrice);
                session.merge(b);
                tx.commit();
                System.out.println("Price updated: " + b);
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // DELETE BOOK
    public void deleteBook(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx  = session.beginTransaction();
        try {
            Book b = session.get(Book.class, id);
            if (b != null) {
                session.remove(b);
                tx.commit();
                System.out.println("Deleted: " + b.getTitle());
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}