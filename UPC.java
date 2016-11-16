
/*Kyle Schwartz
 *Mrs. Krasteva
 *17/11/2016
 *UPC Checker
 */
import hsa.Console;
import hsa.Message;

public class UPC {
	static Console c;
	static char option;
	long upc;
	boolean run = true;

	public UPC() {
		c = new Console();
	} // Class constructor

	private void title() {
		c.clear();
		c.println();
		String s = "How's Your UPC?";
		c.print("", (80 - s.length()) / 2);
		c.println(s);
		c.println();
	}

	private void pauseProgram() {
		c.println("Press any key to continue...");
		c.getChar();
	}

	public void goodBye() {
		title();
		c.println("Thanks for using my program!");
		pauseProgram();
		c.close();
	}

	public void instructions() {
		title();
		c.println("This program will determine if your UPC code is a valid one. "
				+ "A UPC code must be exactly 12 numbers long and must not begin with a 4. "
				+ "If your UPC meets these requirements, it will be accepted and you will told as such. "
				+ "Otherwise, you will begiven an error. Enjoy!");
		pauseProgram();
	}

	public void splashScreen() {
		if (run) {
			c.clear();
			c.drawString("Schwartz", 100, 100);
			c.drawString("Studio", 100, 200);
			c.getChar();
			run = false;
		}
	}

	public void askData() {
		title();
		c.print("Enter UPC: ");
		String upcS = c.readLine();
		try {
			upc = Long.parseLong(upcS);
		} catch (Exception e) {
			new Message("That's not a valid unput!");
			pauseProgram();
			askData();
		}
		if (upc < 100000000000L || upc >= 1000000000000L) {
			new Message("That's not a valid unput!");
			pauseProgram();
			askData();
		}
	}

	public void display() {
		title();
		if (isUPC(upc))
			c.println("That's a valid UPC!");
		else if (!isUPC(upc))
			c.println("Sorry, that's not a valid UPC.");
		pauseProgram();
	}

	private boolean isUPC(long upc) {
		if (upc < 5000000000000L && upc > 399999999999L)
			return false;
		else
			return true;
	}

	public void mainMenu() {
		title();
		c.println("Choose an option:");
		c.println("1) Check UPC Code");
		c.println("2) View Instructions");
		c.println("3) Exit");
		option = c.readChar();
	}

	public static void main(String[] args) {
		UPC u = new UPC();
		while (true) {
			u.splashScreen();
			u.mainMenu();
			if (option == '1') {
				u.askData();
				u.display();
			} else if (option == '2')
				u.instructions();
			else if (option == '3')
				break;
			else {
				c.println("That's not a valid input!");
				u.pauseProgram();
			}

		}
		u.goodBye();
	}
}