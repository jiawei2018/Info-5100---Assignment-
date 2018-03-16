package assignment07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class part3Test {

	@Test
	public void testMain() {
	 
		Scissors s = new Scissors(5);
		Paper p = new Paper(7);
		Rock r = new Rock(15);
		
		Assert.assertTrue(s.fight(p));
		Assert.assertTrue(p.fight(r));
		Assert.assertTrue(r.fight(s));
		
		Assert.assertTrue(!s.fight(s));
		Assert.assertTrue(!s.fight(r));
		
		Assert.assertTrue(!p.fight(p));
		Assert.assertTrue(!p.fight(s));
		
		Assert.assertTrue(!r.fight(r));
		Assert.assertTrue(!r.fight(p));

	}

}
