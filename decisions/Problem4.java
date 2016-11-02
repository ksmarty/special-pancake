package decisions;
/*Kyle Schwartz & Lev Kropp
 *Mrs. Krasteva
 *02/11/2016
 *Decisions Problem 4
 */

import hsa.Console;

public class Problem4 {
	static Console c;

	public Problem4() {
		c = new Console("NUMBERS!");
	}

	public void display() {
		intro();
		
		title();
		c.println("Please enter your first number.");
		int num1 = c.readInt();
		c.println("Please enter your second number.");
		int num2 = c.readInt();
		if (num1 == num2) {
			c.println((num1 + num1) * 2);
		} else {
			c.println(num1 + num2);
		}
		
		outro();
	}

	private void outro() {
		c.println();
		c.print("Thanks for using the program!");
	}
	
	private void title() {
		c.setCursor(1, 1);
		c.print("Problem 4 - Numbers");
		
		c.setCursor(1, 56);
		c.print("Kyle Schwartz & Lev Kropp");
	}
	
	
	private void intro() {
		title();
		c.setCursor(12, 37);
		c.println("NUMBERS!");
		c.setCursor(13, 12);
		c.print("This program will ask for two integers, and if they are the");
		c.setCursor(14, 16);
		c.print("same, double their sum. Otherwise simply add them.");
		c.getChar();
		c.clear();
	}
	
	
	public static void main(String[] args) {
		Problem4 p = new Problem4();
		p.display();
	}
}
