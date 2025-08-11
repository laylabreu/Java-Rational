/** Defining a Rational number class
Refer to the instructions on Canvas for more information.
"I have neither given nor received unauthorized help on this assignment."
author: Layla Maria Abreu
*/

public class Rational {
	
	// These are the instances variables defined for your class.  Don't change these lines!
	private int numerator;
	private int denominator;
	
	/** 
	 * Initialize a new Rational object with value iNum/iDen stored in the numerator and
	 * denominator variables.  Calls the reduce() method to put the fraction in lowest terms.
	 */
	public Rational(int iNum, int iDen) {
		this.numerator = iNum;
		this.denominator = iDen;		
		this.reduce();
	} //Rational (constructor)
	
	public int getNumerator() {
		///    '''returns the value of the numerator of this rational number'''
		return this.numerator;
	} 
	
	public int getDenominator() {
		///''returns the value of the denominator of this rational number'''		
		return this.denominator;
	} //getDenominator	
	
	
	public Rational reciprocal() {
		Rational rational= new Rational(this.denominator, this.numerator);
	    return rational;
	} //reciprocal
	
	public boolean isValid() {
		///''' this function checks to make sure this is a valid rational number mainly by making sure that the denominator does not equal 0'''
		return this.denominator !=0;

	} 
	
	public Rational add(Rational num2) {
		///'''This function returns a new rational number from the addition of itself and another Rational. If the denominators are not equal then the numbers must be scaled up until the denominators match'''
	    int leastdenom = (this.denominator * num2.getDenominator()) /this.gcf();
	    int numerator = (this.numerator * (leastdenom / this.denominator)) +(num2.getNumerator() * (leastdenom / num2.getDenominator()));
	    return new Rational(numerator, leastdenom);
		// Finish this implementation
	} //add
	
	public Rational sub(Rational num2) {
		///''' This function returns a new rational number from the subtraction of another Rational from itself. If the denominators are not equal, then the numbers must be scaled up until the denominators match'''
	    int leastdenom = (this.denominator * num2.getDenominator()) /this.gcf();
	    int numerator = (this.numerator * (leastdenom / this.denominator)) -(num2.getNumerator() * (leastdenom / num2.getDenominator()));

	    return new Rational(numerator, leastdenom);
	}
	
	public Rational mult(Rational num2) {
		///'''This function returns a new rational number from the multiplication of itself and another Rational number.'''
		return new Rational(this.numerator * num2.getNumerator(),this.denominator*num2.getDenominator());
	}
	
	public Rational div(Rational num2) {
		///''' returns True if this rational is less than (lessthan) another rational number. Returns False in all other cases'''
		return new Rational(this.numerator*num2.getDenominator(), this.denominator *num2.getNumerator());
	}
	
	public boolean lessthan(Rational num2) {
		return (this.numerator * num2.getDenominator()) <(num2.getNumerator()* this.denominator);
	
	} 
	

	
	
	
	
	/*******************************
	*    HELPER FUNCTIONS BELOW    *
	*******************************/
	
    /**
     * Reduces the Rational to lowest terms
     * - Checks if both the numerator and denominator are negative; if so, makes
     * both positive
     * - Calls gcf() to find the greatest common factor between the numerator
     * and denominator, and * continues to divide by that gcf until the
     * greatest common factor is 1
     */
    private void reduce() {
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
        int common = this.gcf();
        this.numerator = numerator / common;
        this.denominator = denominator / common;
    } // reduce


    /**
     * Determines the greatest common factor between the numerator and
     * denominator
     * - Starts checking numbers counting downward from the smaller of the
     * numerator,denominator pair
     * - When it finds a number divisible by both, it breaks the loop and
     * returns that number
     * - The smallest number that can be returned is 1
     */
    private int gcf() {
        int absNum = Math.abs(numerator);
        int absDen = Math.abs(denominator);
        int minOfNums = Math.min(absNum, absDen);
        for (int i = minOfNums; i > 0; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                return i;
            }
        }
        return 1;
    } // gcf

	/**
	  Returns a string representation of the Rational, e.g. "1/8"
	*/
	public String toString() {
        String numStr = Integer.toString(this.numerator);
        String denStr = Integer.toString(this.denominator);
        return numStr + "/" + denStr;
	} //toString
	
	/**
	  Determines if two Rationals are exactly equal to each other (same numerator and same 
	  denominator, no consideration of reducing the numbers)
	*/
	public boolean equals(Object other) {
		Rational fraction = (Rational) other;
		int otherNum = fraction.getNumerator();
		int otherDen = fraction.getDenominator();
		if (numerator == otherNum && denominator == otherDen) {
			return true;
		} //if
		return false;
	} //equals
	
	
	/*******************************
	*     END HELPER FUNCTIONS     *
	*******************************/	
	
	/**
	 * This is the main function.  Running the Rational.java file will run this method. 
	 * No need for changes. It is better to put your testing in RationalTest and running that!
	 */
	public static void main(String[] args) {
		System.out.println("You're running the Rational.java file.");
		System.out.println("If you want to test your program,");
		System.out.println("you should run the RationalTest.java file instead!");
	}
	
} //Rational (class)

