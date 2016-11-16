package controlFlow;

/*Kyle Schwartz
 *Mrs. Krasteva
 *09/11/2016
 *Problem 3
 */
import hsa.Console;

public class Problem1 {
	static Console c;
	int year;

	public Problem1() {
		c = new Console();
	} // Class constructor

	public void intro() {
		c.println("What year would you like to determine the leap year status of?");
		year = c.readInt();
		output();
	}

	public void output() {
		if (year <= 0) {
			c.println("Nope. Try again.");
			intro();
		}
		if (year % 4 == 0 && year % 100 != 0) {
			c.println("\nCongratulations! That's a leap year");
		} else if (year % 4 == 0 && year % 400 == 0) {
			c.println("\nCongratulations! That's a leap year");
		} else {
			c.println("\nSorry, that is not a leap year.");
		}
		c.println("\nPress 'c' to use the program again or 'q' to quit...");
		char choice = c.getChar();
		if (choice == 'c')
			intro();
		else if (choice == 'q')
			c.close();
	}

	public static void main(String[] args) {
		Problem1 ts = new Problem1();
		ts.intro();
	}
}