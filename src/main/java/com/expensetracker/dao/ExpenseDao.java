package com.expensetracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.expensetracker.entities.Expense;
import com.expensetracker.entities.User;

public class ExpenseDao {

	private SessionFactory factory;
	private Session session = null;
	private Transaction transaction = null;

	public ExpenseDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public boolean saveExpense(Expense expense) {

		boolean f = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(expense);

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

	public List<Expense> getAllExpenses(User user) {

		List<Expense> list = new ArrayList<Expense>();

		try {
			session = factory.openSession();
			Query query = session.createQuery("from Expense where user=:us");
			query.setParameter("us", user);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Expense getExpenseById(int id) {

		Expense expense = null;

		try {
			session = factory.openSession();
			expense = session.get(Expense.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return expense;

	}

	public boolean updateExpense(Expense expense) {

		boolean f = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(expense);

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

	public boolean deleteExpense(int id) {

		boolean f = false;

		try {

			session = factory.openSession();
			transaction = session.beginTransaction();

			Expense expense = session.get(Expense.class, id);
			session.delete(expense);
			transaction.commit();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
