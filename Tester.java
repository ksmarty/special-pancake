
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/09/2016
 *Template
 */
import hsa.Console;
import hsa.Message;

public class Tester {
	static Console c;
	int num1;
	String numstr;
	double numD;

	public Tester() {
		c = new Console();
	} // Class constructor

	public void output() {
		while (true) {
			try {
				c.print("Enter a number: ");
				numstr = c.readLine();
				num1 = Integer.parseInt(numstr);
				break;
			} catch (NumberFormatException e) {
				new Message("Bad integer. Try again");
			}
		}
		c.println("The integer number is: " + num1);
	}

	public void output2() {
		while (true) {
			try {
				c.print("Enter a number: ");
				numstr = c.readLine();
				numD = Double.parseDouble(numstr);
				break;

			} catch (NumberFormatException e) {
				new Message("Bad double. Try again.");
			}
		}
		c.println("The decimal number is: " + numD);
	}

	public static void main(String[] args) {
		Tester ts = new Tester();
		ts.output2();
	}
}