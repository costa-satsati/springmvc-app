package com.costa.spring.web.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "offers")
public class Offer
{
	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@Size(min = 10, max = 100)
	private String text;
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	public Offer()
	{
		// TODO Auto-generated constructor stub
	}

	public Offer(final User user, final String text)
	{
		this.user = user;
		this.text = text;
	}

	public Offer(final int id, final String text, final User user)
	{

		this.id = id;
		this.text = text;
		this.user = user;
	}

	public boolean isNew()
	{
		return id == 0;
	}

	public int getId()
	{
		return id;
	}

	public void setId(final int id)
	{
		this.id = id;
	}

	public String getText()
	{
		return text;
	}

	public void setText(final String text)
	{
		this.text = text;
	}

	public String getUsername()
	{
		return user.getUsername();
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(final User user)
	{
		this.user = user;
	}

	@Override
	public String toString()
	{
		return "Offer [id=" + id + ", text=" + text + "]";
	}


}
