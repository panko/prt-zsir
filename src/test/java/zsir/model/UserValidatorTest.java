package zsir.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;


public class UserValidatorTest {
	
	UserDAO ud;
	UserValidator uv;
	
	@Before
	public void initialize() {
		ud = UserDAOFactory.getInstance().createDAO();
		ud.createUser("aranka", "jelszo");
		uv = new UserValidator(ud);
	}
	
	@Test
	public void weAlreadyHaveThatTest() {
		assertFalse("do we alreasy have?", uv.regValidate("aranka"));
	}
	
	@Test
	public void zeroUsername() {
		assertFalse("Zero username oke?", uv.regValidate(""));
	}
	
	@Test
	public void canNotWeLoginTest() {
		assertFalse("can we login with BAD name/pass?", uv.loginValidate("bela", "nemjelszo"));
	}
	
	@Test
	public void canWeLoginTest() {
		assertTrue("can we login with good name/pass?", uv.loginValidate("aranka", "jelszo"));
	}
	

}