package assignment07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class part04Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMerge() {
		List<Interval>  t1 = new ArrayList<Interval>();
		Interval a1 = new Interval(1,3);
		Interval a2 = new Interval(2,4);
		Interval a3 = new Interval(5,7);
		Interval a4 = new Interval(6,8);
		
		
		t1.add(a1);
		t1.add(a2);
		t1.add(a3);
		t1.add(a4);
		
		part04 tt = new part04();
		
		Assert.assertTrue(tt.merge(t1).get(0).start == 1);
		Assert.assertTrue(tt.merge(t1).get(0).end == 4);
		Assert.assertTrue(tt.merge(t1).get(1).start == 5);
		Assert.assertTrue(tt.merge(t1).get(1).end == 8);
		
		
		
	}

}
