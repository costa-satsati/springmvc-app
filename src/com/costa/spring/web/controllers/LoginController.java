package com.costa.spring.web.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.costa.spring.web.dao.User;
import com.costa.spring.web.service.UsersService;


@Controller
public class LoginController
{


	private UsersService usersService;

	@Autowired
	public void setUsersService(final UsersService usersService)
	{
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin()
	{
		return "login";
	}

	@RequestMapping("/admin")
	public String showAdmin(final Model model)
	{
		final List<User> users = usersService.getUsers();
		model.addAttribute("users", users);
		return "admin";
	}


	@RequestMapping("/newaccount")
	public String showNewAccount(final Model model)
	{
		model.addAttribute("user", new User());
		return "newaccount";
	}


	@RequestMapping("/createaccount")
	public String createAccount(@Valid final User user, final BindingResult result)
	{
		if (result.hasErrors())
		{
			return "newaccount";
		}
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);

		if (usersService.getUser(user.getUsername()) != null)
		{

			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}

		try
		{
			usersService.create(user);
		}
		catch (final DuplicateKeyException e)
		{
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}


		return "accountcreated";
	}
}

