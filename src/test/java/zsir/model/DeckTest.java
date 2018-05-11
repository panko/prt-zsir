package zsir.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import com.sun.glass.ui.Application;



public class DeckTest extends ApplicationTest {
	
	Deck d;
	
	@Before
	public void initialize() {
		d = new Deck();
	}
	
	@Test
	public void doWeStartWith32() {
		assertEquals("Do we really get 32 card in the beggining", 32, d.getCards().size() );
	}
	
	@Test
	public void testDraw() {
		d.draw();
		assertEquals("Do we have 31 if we draw", 31, d.getCards().size() );
	}

	
}