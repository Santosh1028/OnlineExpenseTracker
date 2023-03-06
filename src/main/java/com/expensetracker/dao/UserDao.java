package com.expensetracker.dao;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.expensetracker.entities.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao {

	private SessionFactory factory;
	private Session session = null;
	private Transaction transaction = null;

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public boolean saveUser(User user) {

		boolean f = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(user);

			transaction.commit();
			session.close();
			f = true;
		} catch (Exception e) {
			if (transaction != null) {
				e.printStackTrace();
			}
		}

		return f;
	}

	public User login(String email, String password) {

		User user = null;

		session = factory.openSession();
		Query query = session.createQuery("from User where email=:em and password=:ps");
		query.setParameter("em", email);
		query.setParameter("ps", password);

		user = (User) query.uniqueResult();

		return user;

	}

}
