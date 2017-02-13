package com.costa.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costa.spring.web.dao.Offer;
import com.costa.spring.web.dao.OffersDao;


@Service("offersService")
public class OffersService
{
	private OffersDao offersDao;

	@Autowired
	public void setOffersDao(final OffersDao offersDao)
	{
		this.offersDao = offersDao;
	}


	public List<Offer> getCurrent()
	{
		return offersDao.getOffers();
	}


	public void create(final Offer offer)
	{
		offersDao.create(offer);

	}


	public void delete(final int id)
	{
		offersDao.delete(id);

	}


	public List<Offer> getOffers(final String username)
	{
		return offersDao.getOffers(username);
	}

	public Offer getOffer(final int id)
	{
		return offersDao.getOffer(id);
	}


	public void update(final Offer offer)
	{
		offersDao.update(offer);

	}

}
