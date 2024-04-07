package org.jsp.merchantproductapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.merchantproductapp.dto.Merchant;

import com.mysql.cj.xdevapi.DbDoc;

public class MerchantDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();

	public Merchant saveMerchant(Merchant merchant) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(merchant);

		transaction.begin();
		transaction.commit();

		return merchant;

	}

	public Merchant updateMerchant(Merchant merchant) {

		EntityTransaction transaction = manager.getTransaction();

		Merchant dbmerchant = manager.find(Merchant.class, merchant.getId());

		if (dbmerchant != null) {

			dbmerchant.setEmail(merchant.getEmail());
			dbmerchant.setGst_number(merchant.getGst_number());
			dbmerchant.setName(merchant.getName());
			dbmerchant.setPassword(merchant.getPassword());
			dbmerchant.setPhone(merchant.getPhone());
			transaction.begin();
			transaction.commit();
			return dbmerchant;

		}
		return null;

	}

	public Merchant findMerchantById(int id) {

		return manager.find(Merchant.class, id);
	}

	public Merchant verifyMerchant(long phone, String password) {

		Query q = manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");

		q.setParameter(1, phone);
		q.setParameter(2, password);

		try {
			return (Merchant) q.getResultStream();
		} catch (NoResultException e) {
			return null;
		}

	}

	public Merchant verifyMerchant(String email, String password) {

		Query q = manager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");

		q.setParameter(1, email);
		q.setParameter(2, password);

		try {
			return (Merchant) q.getResultStream();
		} catch (NoResultException e) {
			return null;
		}

	}

}
