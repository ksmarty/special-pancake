
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/09/2016
 *Template
 */
import hsa.Console;

public class Task1 {
	static Console c;
	double a = 32;
	double b = 63;

	public Task1() {
		c = new Console();
	} // Class constructor

	public void title() {
	}

	public void logo() {
		double sq = 2 * a / b;
		double sqrt = sq / 2;
		double lastsqrt = 0.0;
		while (sqrt != lastsqrt) {
			lastsqrt = sqrt;
			sqrt = (lastsqrt + sq / lastsqrt) / 2;
		}
		c.print(sqrt);
	}

	public static void main(String[] args) {
		Task1 ts = new Task1();
		ts.title();
		ts.logo();
	}
}
