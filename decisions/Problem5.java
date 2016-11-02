package decisions;

/*Kyle Schwartz & Lev Kropp
 *Mrs. Krasteva
 *02/11/2016
 *Decisions Problem 5
 */

import hsa.Console;


public class Problem5 {
	
	
	Console c;
	
	public Problem5(){
		c = new Console("Three or Five");
	}
	
	public static void main(String[] args) {
		Problem5 p = new Problem5();
		p.display();
	}
	
	public void display() {
		intro();

		title();
		c.println("Enter a positive integer:");
		int num = c.readInt();
		
		if (calc(num)) {
			c.print(num+" is divisible by 3 or 5!");
		} else {
			c.print(num+" is NOT divisible by 3 or 5!");
		}
		
		outro();
		
	}
	
	private boolean calc(int num) {

		if (num % 3 == 0 && num > 0 || num % 5 == 0 && num > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private void outro() {
		c.println();
		c.print("Thanks for using the program!");
	}
	
	private void title() {
		c.setCursor(1, 1);
		c.print("Problem 5 - Three or Five?");
		
		c.setCursor(1, 56);
		c.print("Kyle Schwartz & Lev Kropp");
	}
	
	private void intro() {
		title();
		c.setCursor(12, 38);
		c.println("3 OR 5");
		c.setCursor(13, 12);
		c.print("This program will check a positive integer if it is divisble");
		c.setCursor(14, 21);
		c.print("by three or five and output true if it is.");
		c.getChar();
		c.clear();
	}
}