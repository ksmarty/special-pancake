package controlFlow;

/*Kyle Schwartz & Lev Kropp
 *Mrs. Krasteva
 *09/11/2016
 *Problem 3
 */
import hsa.Console;

public class Problem3 {
	static Console c;

	public Problem3() {
		c = new Console();
	} // Class constructor

	public void output() {
		// Get password
		c.print("Please enter your password: ");
		String pass = c.readString();
		char[] passArray = pass.toCharArray();
		int len = pass.length();

		// Creates an array with all acceptable values to brute force
		char[] codes = new char[95];
		int pos = 0;

		// Adds Numbers
		for (char x = 33; x < 127; x++) {
			codes[pos] = x;
			pos++;
		}

		// Where the hacking happens
		// Found Password Variable
		char[] passFound = new char[len];
		// Runs as many times as length of the password, once for each password
		// character
		for (int x = 0; x < len; x++) {
			// Checks each of the 64 possible characters
			for (pos = 0; pos < 95; pos++) {
				// Checks if character is = to password char. If it is, it
				// breaks the loop and continues to the next part of the
				// password.
				if (passArray[x] == codes[pos]) {
					passFound[x] = codes[pos];
					break;
				}
			}
		}
		// Converts the found char array to a string.
		String passString = new String(passFound);
		c.println("Your password is: " + passString);
	}

	public static void main(String[] args) {
		Problem3 ts = new Problem3();
		ts.output();
	}
}