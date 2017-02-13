package com.costa.spring.web.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "users")
public class User
{
	@NotBlank
	@Size(min = 5, max = 15)
	@Id
	private String username;
	@NotBlank
	@Size(min = 6, max = 15)
	private String password;
	private boolean enabled = false;
	private String authority;
	@NotNull
	@Size(min = 10, max = 80)
	private String name;
	@Email
	private String email;

	public User()
	{
		// TODO Auto-generated constructor stub
	}



	public User(final String username, final String password, final boolean enabled, final String authority, final String name,
			final String email)
	{
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.name = name;
		this.email = email;
	}



	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(final boolean enabled)
	{
		this.enabled = enabled;
	}

	public String getAuthority()
	{
		return authority;
	}

	public void setAuthority(final String authority)
	{
		this.authority = authority;
	}



	public String getName()
	{
		return name;
	}



	public void setName(final String name)
	{
		this.name = name;
	}



	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final User other = (User) obj;
		if (authority == null)
		{
			if (other.authority != null)
			{
				return false;
			}
		}
		else if (!authority.equals(other.authority))
		{
			return false;
		}
		if (email == null)
		{
			if (other.email != null)
			{
				return false;
			}
		}
		else if (!email.equals(other.email))
		{
			return false;
		}
		if (enabled != other.enabled)
		{
			return false;
		}
		if (name == null)
		{
			if (other.name != null)
			{
				return false;
			}
		}
		else if (!name.equals(other.name))
		{
			return false;
		}
		if (username == null)
		{
			if (other.username != null)
			{
				return false;
			}
		}
		else if (!username.equals(other.username))
		{
			return false;
		}
		return true;
	}



}
