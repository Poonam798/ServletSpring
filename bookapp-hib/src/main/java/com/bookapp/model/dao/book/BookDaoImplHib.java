package com.bookapp.model.dao.book;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookapp.model.dao.factories.HibernateSessionFactory;
import com.bookapp.model.exceptions.BookNotFoundException;
import com.bookapp.model.exceptions.DataAccessException;

public class BookDaoImplHib implements BookDao {
	private SessionFactory factory;

	public BookDaoImplHib() {
		factory = HibernateSessionFactory.getSessionFactory();
	}

	private Session getSession() {
		return factory.openSession();
	}

	@Override
	public List<Book> getAllBooks() {
		return getSession().createQuery("select b from Book b", Book.class).getResultList();
	}

	@Override
	public Book addBook(Book book) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(book);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
			throw new DataAccessException(ex.getMessage());

		}
		return book;
	}

	@Override
	public Book delBook(int id) {
		Book book = null;
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			book = getBookById(id);
			session.delete(book);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
			throw new DataAccessException(ex.getMessage());

		}
		return book;

	}

	@Override
	public Book updateBook(int id, double price) {
		Book book = null;
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			book = getBookById(id);
			book.setPrice(price);
			session.update(book);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
			throw new DataAccessException(ex.getMessage());

		}
		return book;
	}

	@Override
	public Book getBookById(int id) {
		Session session = factory.openSession();
		Book book = session.get(Book.class, id);
		if (book == null)
			throw new BookNotFoundException("book with id " + id + " is not found");
		return book;
	}

}
