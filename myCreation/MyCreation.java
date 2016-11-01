package myCreation;
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/10/2016
 *My Creation Class
 */

import hsa.Console;

public class MyCreation {
	private Console c;
	// Declares end to be false
	static boolean end = false;

	// Background Method
	public void background() {
		// Calling Background

		Background b = new Background(c);
		// Draw Background
		b.draw();
	}

	// Pumpkin Method (Overloaded)
	public void pumpkin() {
		// Method 1
		Pumpkin p = new Pumpkin(c);

		// Run Method 1
		p.run();

		// Method 2
		Pumpkin p1 = new Pumpkin(c, M.PUMPKIN2);

		// Run Method 2
		p1.run();

		// Method 3
		Pumpkin p2 = new Pumpkin(c, M.PUMPKIN3, 200);

		// Run Method 3
		p2.run();
	}

	// Cross Method
	public void cross() {
		// Calling Cross
		Cross r = new Cross(c);

		// Starts Cross
		r.start();
	}

	// Stone Method
	public void stone() {
		// Calling Stone
		Stone s = new Stone(c);

		// Starts Stone
		s.start();
	}

	// Tree method
	public void tree() {
		// Calling Tree
		Tree t = new Tree(c);

		// Starts Tree
		t.start();
	}

	// Moon Method
	public void moon() {
		// Calling Moon
		Moon m = new Moon(c);

		// Starts Moon
		m.start();
	}

	// Star Method
	public void star() {
		// Calling Star
		Star s = new Star(c);

		// Starts Star
		s.run();
	}

	// Outro Method
	public void outro() {
		// Calling Outro
		Outro o = new Outro(c);

		// Starts Outro
		o.run();
	}

	// Creates a new window and titles it
	public MyCreation() {
		c = new Console("Pumpkins Night Out");
	}

	// Main Method
	public static void main(String[] args) {
		MyCreation m = new MyCreation();
		m.background();
		m.moon();
		m.cross();
		m.stone();
		m.tree();
		m.pumpkin();
		m.star();
		m.outro();
	}
}
