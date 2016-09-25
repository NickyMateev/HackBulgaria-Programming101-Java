package simple;

import static org.junit.Assert.*;

import org.junit.Test;

public class DemoTest {

	// pass
	@Test
	public void testAdd() {
		SimpleCalculator calculator = new SimpleCalculator();
		int expected = 8;
		int actual = calculator.add(2, 6);
		assertEquals("Test if addition works.", expected, actual);
	}
	
	// fail
	@Test
	public void testSubtract(){
		fail("Not yet implemented");
	}

	// fail
	@Test
	public void testDivide(){
		fail("Not yet implemented.");
	}

}
