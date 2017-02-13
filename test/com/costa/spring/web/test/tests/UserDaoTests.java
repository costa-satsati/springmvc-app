package com.costa.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import com.costa.spring.web.dao.User;
import com.costa.spring.web.dao.UsersDao;


@ActiveProfiles("dev")
@ContextConfiguration(locations =
{ "classpath:com/costa/spring/web/config/dao-context.xml", "classpath:com/costa/spring/web/config/security-context.xml",
		"classpath:com/costa/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests
{
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private DataSource dataSource;

	private final User user1 = new User("costa", "123456", true, "ROLE_USER", "Costa Sattsaev", "costa@spring.com");
	private final User user2 = new User("chris", "qwerty", true, "ROLE_ADMIN", "Chris Crter", "chris@spring.com");
	private final User user3 = new User("james", "helloworld", true, "ROLE_USER", "James Bond", "james@spring.com");
	private final User user4 = new User("alexg", "letmein", true, "user", "Alex Groove", "alex@spring.com");


	@Before
	public void init()
	{
		final JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}

	@Test
	public void testCreateRetrieve()
	{
		usersDao.create(user1);
		final List<User> users1 = usersDao.getUsers();
		assertEquals("Number of users should be 1.", 1, users1.size());
		assertEquals("Inserted user must match retrieved", user1, users1.get(0));

		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		final List<User> users2 = usersDao.getUsers();
		assertEquals("Number of users should be 4.", 4, users2.size());
	}

	@Test
	public void testUsers()
	{
		final User user = new User("costa", "123456", true, "ROLE_USER", "Costa Sattsaev", "costa@spring.com");
		usersDao.create(user);

		final List<User> users = usersDao.getUsers();

		assertEquals("Number of users should be 1.", 1, users.size());
		assertTrue("User should exists", usersDao.getUser(user.getUsername()) != null);

	}
}
