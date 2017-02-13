package com.costa.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.costa.spring.web.dao.User;
import com.costa.spring.web.dao.UsersDao;


@Service("usersService")
public class UsersService
{
	private UsersDao usersDao;

	@Autowired
	public void setUsersDao(final UsersDao usersDao)
	{
		this.usersDao = usersDao;
	}


	public void create(final User user)
	{
		usersDao.create(user);

	}


	@Secured("ROLE_ADMIN")
	public List<User> getUsers()
	{
		return usersDao.getUsers();
	}

	public User getUser(final String username)
	{
		return usersDao.getUser(username);

	}

}
