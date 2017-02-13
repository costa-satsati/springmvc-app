package com.costa.spring.web.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Component("usersDao")
@Transactional
public class UsersDao
{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private SessionFactory sessionFactory;


	private Session session()
	{
		return sessionFactory.getCurrentSession();

	}

	public void create(final User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}

	public List<User> getUsers()
	{

		return session().createQuery("from User").getResultList();

	}

	public User getUser(final String username)
	{
		final CriteriaBuilder builder = session().getCriteriaBuilder();
		final CriteriaQuery<User> criteria = builder.createQuery(User.class);
		final Root<User> root = criteria.from(User.class);
		criteria.where(builder.equal(root.get("username"), username));
		return session().createQuery(criteria).getSingleResult();
	}

}
