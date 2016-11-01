
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/09/2016
 *For Loops 1
 */
import hsa.Console;

public class Quiz1A {
	Console c;

	public Quiz1A() {
		c = new Console();
	}

	public void triangle() {
		double len1;
		double len2;
		len1 = c.readDouble();
		len2 = c.readDouble();
		double answer = (Math.sqrt(len1 * len1 + len2 * len2) * 1000 / 1000);
		c.println(answer, 5, 3);
	}

	public void strings() {
		String userInput = c.readString();
		for (int x = 2; x <= userInput.length(); x += 3) {
			c.println(userInput.charAt(x));
		}
	}

	public static void main(String[] args) {
	}
}
