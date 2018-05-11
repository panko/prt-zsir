package zsir.model.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import zsir.model.Card;
import zsir.model.Deck;


public class AITest extends ApplicationTest {
	
	AI ai;
	
	Deck d;
	
	@Before
	public void init() {
		ai = new AI(null);
		d = new Deck();
	}
	
	@Test
	public void testPasst() {
		assertTrue("we programme to always pass", ai.doIPass());
	}
	
	@Test
	public void testDraw() {
		ai.draw(d);
		assertEquals("if we draw we have one card", 1, ai.getNumOfCards());
	}

	
}