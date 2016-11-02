package decisions;

/*Kyle Schwartz & Lev Kropp
 *Mrs. Krasteva
 *02/11/2016
 *Decisions Problem 6
 */

import hsa.Console;


public class Problem6 {
	
	
	Console c;
	
	public Problem6(){
		c = new Console("Not Strings");
	}
	
	public static void main(String[] args) {
		Problem6 p = new Problem6();
		p.display();
	}
	
	public void display() {
		intro();
		
		title();
		c.println("Enter a string:");
		String s = c.readLine();
		
		if (s.length() >= 3) {
			if (s.substring(0,3).equalsIgnoreCase("not")) {
				c.println(s);
			} else {
				s = "not"+s;
				c.println(s);
			}
		} else {
			c.print("That string is too short!");
		}
		
		outro();
		
	}
	
	private void outro() {
		c.println();
		c.print("Thanks for using the program!");
	}
	
	private void title() {
		c.setCursor(1, 1);
		c.print("Problem 6 - Not Strings");
		
		c.setCursor(1, 56);
		c.print("Kyle Schwartz & Lev Kropp");
	}
	
	private void intro() {
		title();
		c.setCursor(12, 35);
		c.println("NOT STRINGS!");
		c.setCursor(13, 16);
		c.print("This program will add not to the beginning of any ");
		c.setCursor(14, 20);
		c.print("string unless it already begins with not.");
		c.getChar();
		c.clear();
	}

}
	