package zsir.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserDAOImplTest {

	
	UserDAO ud;
	
	@Before
	public void initialize() {
		ud = UserDAOFactory.getInstance().createDAO();
	}
	
	@Test
	public void testUserCreation() {
		ud.createUser("aranka", "szivarvany");
		assertEquals("can we create a user", 1, ud.getUser("aranka").size());
	}
}