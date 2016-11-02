package decisions;
/*Kyle Schwartz & Lev Kropp
 *Mrs. Krasteva
 *02/11/2016
 *Decisions Problem 3
 */

import hsa.Console;

public class Problem3 {
	static Console c;

	public Problem3() {
		c = new Console("PACKAGES!");
	}

	public void display() {
		intro();
		
		title();
		c.println("How heavy is your package in kg?");
		double kg = c.readDouble();
		c.println("What is the length of your package in cm?");
		double length = c.readDouble();
		c.println("What is the width of your package in cm?");
		double width = c.readDouble();
		c.println("What is the height of your package in cm?");
		double height = c.readDouble();

		if (kg > 27 && length * width * height > 100000)
			c.println("Your package is too heavy and too large. Sorry.");
		else if (kg > 27) 
			c.println("Your package is too heavy. Sorry.");
		else if (length * width * height > 100000)
			c.println("Your package is too large. Sorry.");
		else
			c.println("Your package is good to go!");
		
		outro();
		
	}

	private void outro() {
		c.println();
		c.print("Thanks for using the program!");
	}
	
	private void title() {
		c.setCursor(1, 1);
		c.print("Problem 3 - Packages");
		
		c.setCursor(1, 56);
		c.print("Kyle Schwartz & Lev Kropp");
	}
	
	private void intro() {
		title();
		c.setCursor(12, 37);
		c.println("PACKAGES!");
		c.setCursor(13, 15);
		c.print("This program will ask for information about your package");
		c.setCursor(14, 16);
		c.print("and tell you whether you are able to ship it or not.");
		c.getChar();
		c.clear();
	}
	
	
	public static void main(String[] args) {
		Problem3 p = new Problem3();
		p.display();
	}
}
