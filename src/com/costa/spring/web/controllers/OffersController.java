package com.costa.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.costa.spring.web.dao.Offer;
import com.costa.spring.web.dao.User;
import com.costa.spring.web.service.OffersService;
import com.costa.spring.web.service.UsersService;


@Controller
public class OffersController
{

	private OffersService offersService;
	@Autowired
	private UsersService usersService;

	@Autowired
	public void setOffersService(final OffersService offersService)
	{
		this.offersService = offersService;
	}

	//List Users Offers
	@RequestMapping("/offers/list")
	public String listOffers(final Model model, final Principal principal)
	{
		final List<Offer> myoffers = offersService.getOffers(principal.getName());
		model.addAttribute("myoffers", myoffers);
		return "myoffers";
	}


	// Create New Offer
	@RequestMapping("/offers/add")
	public String addOffer(final Model model)
	{
		model.addAttribute("offerForm", new Offer());
		return "offerform";
	}

	// Save or update offer
	@RequestMapping(value = "/offers", method = RequestMethod.POST)
	public String saveOrUpdateOffer(final Model model, @ModelAttribute("offerForm") @Valid final Offer offer,
			final BindingResult result, final Principal principal)
	{
		if (result.hasErrors())
		{
			return "offerform";
		}

		final User user = usersService.getUser(principal.getName());
		offer.setUser(user);

		if (offer.isNew())
		{
			offersService.create(offer);
		}
		else
		{
			offersService.update(offer);
		}

		return "offercreated";
	}

	// update offer
	@RequestMapping(value = "/offers/{id}/update")
	public String updateOffer(@PathVariable("id") final int id, final Model model)
	{

		final Offer offer = offersService.getOffer(id);
		model.addAttribute("offerForm", offer);

		return "offerform";
	}

	// delete offer
	@RequestMapping(value = "/offers/{id}/delete")
	public String deleteOffer(@PathVariable final int id, final Model model)
	{
		offersService.delete(id);
		return "myoffers";
	}

}
