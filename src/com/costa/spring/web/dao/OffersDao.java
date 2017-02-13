package com.costa.spring.web.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
@Component("offersDao")
public class OffersDao
{

	@Autowired
	private SessionFactory sessionFactory;


	private Session session()
	{
		return sessionFactory.getCurrentSession();

	}

	public List<Offer> getOffers()

	{
		final CriteriaBuilder builder = session().getCriteriaBuilder();
		final CriteriaQuery<Offer> criteria = builder.createQuery(Offer.class);
		final Root<Offer> root = criteria.from(Offer.class);
		criteria.select(root);
		return session().createQuery(criteria).getResultList();
	}

	public List<Offer> getOffers(final String username)

	{
		final CriteriaBuilder builder = session().getCriteriaBuilder();
		final CriteriaQuery<Offer> criteria = builder.createQuery(Offer.class);
		final Root<Offer> root = criteria.from(Offer.class);
		criteria.where(builder.equal(root.get("user").get("username"), username));
		return session().createQuery(criteria).getResultList();
	}


	public Offer getOffer(final int id)

	{
		return session().get(Offer.class, id);
	}

	public void update(final Offer offer)
	{
		session().saveOrUpdate(offer);
	}

	public void create(final Offer offer)
	{
		session().save(offer);
	}

	public void delete(final int id)
	{
		final Offer offer = session().get(Offer.class, id);
		session().delete(offer);
	}


}
