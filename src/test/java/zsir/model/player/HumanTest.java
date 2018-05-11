package zsir.model.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import zsir.model.Deck;


public class HumanTest extends ApplicationTest {

	
	Human h;
	
	Deck d;
	
	@Before
	public void init() {
		h = new Human(null);
		d = new Deck();
	}
	
	
	@Test
	public void testNoDraw() {
		assertEquals("if we now draw we have no card", 0, h.getNumOfCards());
	}
	
	@Test
	public void testDraw() {
		h.draw(d);
		assertEquals("if we draw we have one card", 1, h.getNumOfCards());
	}


}