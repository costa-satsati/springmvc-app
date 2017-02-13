package com.costa.spring.web.test.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.costa.spring.web.dao.Offer;
import com.costa.spring.web.dao.OffersDao;
import com.costa.spring.web.dao.User;
import com.costa.spring.web.dao.UsersDao;



@ActiveProfiles("dev")
@ContextConfiguration(locations =
{ "classpath:com/costa/spring/web/config/dao-context.xml", "classpath:com/costa/spring/web/config/security-context.xml",
		"classpath:com/costa/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDaoTests
{

	@Autowired
	private OffersDao offersDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init()
	{
		final JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}

	@Test
	public void testCreate()
	{
		final User user = new User("costa", "123456", true, "ROLE_USER", "Costa Sattsaev", "costa@spring.com");
		usersDao.create(user);

		final Offer offer = new Offer(user, "This is a test offer.");

		offersDao.create(offer);
		final List<Offer> offers = offersDao.getOffers();
		final Offer rOffer = offers.get(0);
		assertEquals("Should be one offer in database.", 1, offers.size());
		assertEquals("Username ", "costa", rOffer.getUsername());
		rOffer.setText("Updated offer text.");
		offersDao.update(rOffer);
	}


	public void testOffers()
	{

		final User user = new User("costa", "123456", true, "ROLE_USER", "Costa Sattsaev", "costa@spring.com");

		Offer offer = new Offer(user, "This is a test offer.");

		offersDao.create(offer);

		final List<Offer> offers = offersDao.getOffers();

		assertEquals("Should be one offer in database.", 1, offers.size());

		//assertEquals("Retrieved offer should match created offer.", offer, offers.get(0));

		// Get the offer with ID filled in.
		offer = offers.get(0);

		offer.setText("Updated offer text.");
		offersDao.update(offer);

		final Offer updated = offersDao.getOffer(offer.getId());

		//assertEquals("Updated offer should match retrieved updated offer", offer, updated);

		// Test get by ID ///////
		final Offer offer2 = new Offer(user, "This is a test offer.");

		offersDao.create(offer2);

		final List<Offer> userOffers = offersDao.getOffers(user.getUsername());
		assertEquals("Should be two offers for user.", 2, userOffers.size());

		final List<Offer> secondList = offersDao.getOffers();

		for (final Offer current : secondList)
		{
			final Offer retrieved = offersDao.getOffer(current.getId());

			//assertEquals("Offer by ID should match offer from list.", current, retrieved);
		}

		// Test deletion
		offersDao.delete(offer.getId());

		final List<Offer> finalList = offersDao.getOffers();

		assertEquals("Offers lists should contain one offer.", 1, finalList.size());
	}

}
