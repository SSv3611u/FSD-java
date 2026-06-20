package com.example.dao;

import com.example.entity.Product;
import com.example.util.Utility;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ProductDAO {

	// SAVE
	public void save(Product p) {
		Session session = Utility.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(p);
			tx.commit();
			System.out.println("Saved: " + p);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// GET ALL
	public List<Product> getAll() {
		Session session = Utility.getSessionFactory().openSession();
		try {
			return session.createQuery("FROM Product", Product.class).list();
		} finally {
			session.close();
		}
	}

	// GET BY ID
	public Product getById(int id) {
		Session session = Utility.getSessionFactory().openSession();
		try {
			return session.get(Product.class, id);
		} finally {
			session.close();
		}
	}

	// UPDATE
	public void update(int id, double newPrice) {
		Session session = Utility.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Product p = session.get(Product.class, id);
			if (p != null) {
				p.setPrice(newPrice);
				session.merge(p);
				tx.commit();
				System.out.println("Updated: " + p);
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// DELETE
	public void delete(int id) {
		Session session = Utility.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Product p = session.get(Product.class, id);
			if (p != null) {
				session.remove(p);
				tx.commit();
				System.out.println("Deleted id: " + id);
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}