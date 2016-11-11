
/*Kyle Schwartz
 *Mrs. Krasteva
 *01/11/2016
 *Conditionals
 */
import hsa.Console;

public class Conditionals {
	Console c;
	int answer;

	public Conditionals() {
		c = new Console();
	} // Class constructor

	public void askData() {
		drawTitle();
		c.println("10 - 20: ");
		answer = c.readInt();
	}

	public void displayData() {
		drawTitle();
		switch (answer) {
		case 10:
		case 9:
			c.println("High");
			break;
		case 15:
			c.println("Mid");
			break;
		default:
			c.println("High");
			break;
		}
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
