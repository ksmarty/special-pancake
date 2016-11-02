package decisions;

/*Kyle Schwartz & Lev Kropp
 *Mrs. Krasteva
 *02/11/2016
 *Decisions Problem 2
 */

import hsa.Console;

public class Problem2 {
	
	
	Console c;
	
	public Problem2(){
		c = new Console("Vacations");
	}
	
	public static void main(String[] args) {
		Problem2 p = new Problem2();
		p.display();
	}
	
	public void display() {
		intro();

		title();
		c.println("Is it a vacation? (true/false) ");
		boolean vacation = c.readBoolean();
		c.println("Is it a weekday? (true/false) ");
		boolean weekday = c.readBoolean();
		
		if (sleepIn(vacation, weekday)) {
			c.print("You can sleep in today!");
		} else {
			c.print("You can NOT sleep in today!");
		}
		
		
		outro();
	}
	
	private boolean sleepIn (boolean vacation, boolean weekday) {
		
		if (vacation || !weekday) {
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
		c.print("Problem 2 - Sleeping In");
		
		c.setCursor(1, 56);
		c.print("Kyle Schwartz & Lev Kropp");
	}
	
	private void intro() {
		title();
		c.setCursor(12, 38);
		c.println("VACATIONS");
		c.setCursor(13, 15);
		c.print("This program will ask if it's a vacation or a weekday");
		c.setCursor(14, 17);
		c.print("if it is the former or not the latter, sleep in!");
		c.getChar();
		c.clear();
	}
}
	