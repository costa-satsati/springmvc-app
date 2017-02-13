package com.costa.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class OfferRowMapper implements RowMapper<Offer>
{

	@Override
	public Offer mapRow(final ResultSet arg0, final int rowNum) throws SQLException
	{

		final User user = new User();
		user.setAuthority(arg0.getString("authority"));
		user.setEmail(arg0.getString("email"));
		user.setEnabled(true);
		user.setName(arg0.getString("name"));
		user.setUsername(arg0.getString("username"));

		final Offer offer = new Offer();
		offer.setId(arg0.getInt("id"));
		offer.setText(arg0.getString("text"));
		offer.setUser(user);

		return offer;
	}

}
