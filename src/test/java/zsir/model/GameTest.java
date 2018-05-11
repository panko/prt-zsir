package zsir.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;


public class GameTest extends ApplicationTest {
	
	Game g;
	
	@Before
	public void initialize() {
		g = new Game(null);
	}
	
	@Test
	public void testSameCards() {
		assertTrue("If called and caller is the same", g.isHitHappened(new Card(Card.Suit.BELLS, Card.Rank.ACE), new Card(Card.Suit.ACORNS, Card.Rank.ACE)));
	}
	
	@Test
	public void testNoSeven() {
		assertFalse("If caller is seven called dont, false", g.isHitHappened(new Card(Card.Suit.ACORNS, Card.Rank.SEVEN), new Card(Card.Suit.ACORNS, Card.Rank.UNDER)));
	}
	
	@Test
	public void testSeven1() {
		assertTrue("If called is seven, always true", g.isHitHappened(new Card(Card.Suit.HEARTS, Card.Rank.TEN), new Card(Card.Suit.ACORNS, Card.Rank.SEVEN)));
		
	}
	
	@Test
	public void testSeven2() {
		assertTrue("If called is seven, always true", g.isHitHappened(new Card(Card.Suit.ACORNS, Card.Rank.SEVEN), new Card(Card.Suit.HEARTS, Card.Rank.SEVEN)));
	}
}

