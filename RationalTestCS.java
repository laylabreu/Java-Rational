import junit.framework.TestCase;

/** The RationalTest unit test class.  
Refer to the instructions on Canvas for more information.
"I have neither given nor received unauthorized help on this assignment."
author: Layla Maria Abreu
 */

// Note: If you see problems, red underlines, or have trouble running this file: 
// You need to add the 'JUnit 3' library to your project.  Look at the 
// 'Package Explorer' view on the left.  Right click your project there. 
// Find 'Build Path' -> 'Add Libraries'.  Then select JUnit 3.  Now you are good!

// Once you have JUnit 3, running this file as 'JUnit' should show a view on the left. 
// That view should say "Runs: 3/3  Errors:0  Failures:0" and have a green bar.  
// You can also expand out the 'RationalTest' folder there to see each test result

public class RationalTest extends TestCase {

	public void testToString() {
		Rational r = new Rational(4, 7);
		String s = r.toString();
		assertEquals("4/7", s);
		int variFive = 2+3;
		assertEquals(5, variFive);
		// ^^^ To show you how JUnit does equals assertions.  
		// You should be doing something similar on your tests below!
	}

    public void testNullAndBoolean() {
        Rational r = null;
        assertNull(r); 
        r = new Rational(3, 5);
        assertNotNull(r);
        // ^^^ Shows you how JUnit does null assertions
        
        boolean shouldBeTrue = 3 == 1+2;
        assertTrue(shouldBeTrue);
        String msg = "this message is for when an assertion fails";
        assertTrue(msg, shouldBeTrue);
        // ^^^ Shows you how JUnit does boolean assertions
    }
    
    public void testRational() {
    	
    	assertEquals("constructor is not correctly reducing 2/3 correctyly.", "2/3", new Rational(2,3).toString());
    	assertEquals("constructor should reduce and correct sign of -4/-8 to 1/2.", "1/2", new Rational(-4,-8).toString());
    	assertEquals("constructor  should reduce 16/20 to 4/5.", "4/5", new Rational(16,20).toString());
    }

    
	public void testGetNumerator() {
		assertEquals("The numerator of 2/3 is 2", 2, new Rational(2,3).getNumerator());
		assertEquals("The numerator of 28/360 (simplified) is 7", 7, new Rational(28,360).getNumerator());
		assertEquals("The numerator of 50/3 is 50", 50, new Rational(50,3).getNumerator());
	}
	
		public void testGetDenominator() {
		assertEquals("The denominator of 2/3 is 3", 3, new Rational(2,3).getDenominator());
		assertEquals("The denominator of 5/29 is 29", 29, new Rational(5,29).getDenominator());
		assertEquals("The denominator of 5/4 is 4", 4, new Rational(5,4).getDenominator());
		}
		
	public void testIsValid() {
		assertTrue("3/4 should be valid", new Rational(3,4).isValid());
		assertTrue("2/4 should be valid", new Rational(2,4).isValid());
		assertFalse("3/0 should not be valid", new Rational(3,0).isValid());
	}


	public void testReciprocal() {
		assertEquals("Reciprocal of 4/5 should 5/4", "5/4", new Rational(4,5).reciprocal().toString());
		assertEquals("Reciprocal of 6/4 should 2/3", "2/3", new Rational(6,4).reciprocal().toString());
		assertEquals("Reciprocal of 7/2 should 2/7", "2/7", new Rational(7,2).reciprocal().toString());
	}
	public void testAdd() {
		assertEquals("10/199 + 100/199 equals 110/199", new Rational(10,199).add(new Rational(100,199)), new Rational(110, 199));
		assertEquals("3/22 + 3/22 equals 3/11", new Rational(3,22).add(new Rational(3,22)), new Rational(3, 11));
		assertEquals("3/4 + 1/4 equals 1/2", new Rational(3,4).add(new Rational(1,4)), new Rational(1, 1));
	}
		
	public void testSub() {
		assertEquals("3/4 - 1/4 should be 1/2", new Rational(3,4).sub(new Rational(1,4)), new Rational(1,2));		
		assertEquals("2/3 - 1/3 should be 1/3", new Rational(2,3).sub(new Rational(1,3)), new Rational(1,3));		
		assertEquals("3/7 - 1/7 should be 2/7", new Rational(3,7).sub(new Rational(1,7)), new Rational(2,7));		
	}
	public void testMult() {
		assertEquals("2/3*3/4 equals 1/2",new Rational(2,3).mult(new Rational(3,4)), new Rational(1,2));
		assertEquals("8/20*4/16 equals 1/10",new Rational(8,20).mult(new Rational(4,16)), new Rational(1,10));
		assertEquals("6/2*2/4 equals 3/2",new Rational(6,2).mult(new Rational(2,4)), new Rational(3,2));
	}

	public void testDiv() {
		assertEquals("3/4 divided by 2/3 is 9/8", new Rational(3,4).div(new Rational(2,3)), new Rational(9,8));
		assertEquals("20/4 divided by 9/17 is 340/36", new Rational(20,4).div(new Rational(9,17)), new Rational(340,36));
		assertEquals("1/5 divided by 3/7 is 7/15", new Rational(1,5).div(new Rational(3,7)), new Rational(7,15));
	}
	public void testLessThan() {
		Rational r1 = new Rational(1,3);
		Rational r2= new Rational(2,3);
		Rational r3= new Rational(4,3);
	    assertFalse("4,3 should not be less than 2/3", r3.lessthan(r2));
		assertTrue("1/3 is less than 2/3", r1.lessthan(r2));
		assertFalse("2/3 should not be less than 1/3", r2.lessthan(r1));
	}
		
		// Fill this out!
		// Make sure you create a Rational, and call the getNumerator() method
		// Then assert that the numerator is what you expect
	
	
	public String notATestJustAHelper() {
		// I am not a test, but can help out other methods, if they call on me. 
		// You can also make more helpers if you like. 
		return "I could return something useful?";
	}

    // Given for test coverage of starter code not written by you!
    public void testStarterCode() {
        Rational.main(null);
        Rational r = new Rational(1,1);
        assertNotNull(r.toString());
        assertTrue(r.equals(r));
    }
	
}
