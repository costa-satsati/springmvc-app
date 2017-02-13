package com.costa.spring.web.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.costa.spring.web.dao.Offer;
import com.costa.spring.web.service.OffersService;


@Controller
public class HomeController
{
	private static Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private OffersService offersService;

	@RequestMapping("/")
	public String showHome(final Model model)
	{
		final List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		return "home";
	}

}
