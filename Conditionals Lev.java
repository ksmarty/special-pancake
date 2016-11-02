
/*Kyle Schwartz
 *Mrs. Krasteva
 *01/11/2016
 *Conditionals
 */
import hsa.Console;

public class Conditionals {
	Console c;
	int num1, num2, num3;

	public Conditionals() {
		c = new Console();
	} // Class constructor

	public void askData() {
		drawTitle();
		c.println("Enter 3 numbers and this'll output the largest");
		num1 = c.readInt();
		num2 = c.readInt();
		num3 = c.readInt();
	}

	public void displayData() {
		drawTitle();
		if (num1 > num2 && num1 > num3)
			c.println(num1 + " is the greatest.");
		else if (num2 > num1 && num2 > num3)
			c.println(num2 + " is the greatest.");
		else if (num3 > num1 && num3 > num2)
			c.println(num3 + " is the greatest.");
	}

	private void drawTitle() {
		c.print(' ', 34);
		c.println("Conditionals");
		c.println();
	}

	public static void main(String[] args) {
		Conditionals ts = new Conditionals();
		ts.askData();
		ts.displayData();
	}
}
