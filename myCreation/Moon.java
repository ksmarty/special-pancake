package myCreation;
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/10/2016
 *Moon Class
 */

import java.awt.Color;

import hsa.Console;

public class Moon extends Thread {
	private Console c;

	// Method that adds colour to the fillStar command
	public void fillStar(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a star
		c.fillStar(x, y, width, height);
	}

	// Method that adds colour to the fillOval command
	public void fillOval(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws an oval
		c.fillOval(x, y, width, height);
	}

	// Method that adds colour to the fillRect command
	public void fillBox(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a rectangle
		c.fillRect(x, y, width, height);
	}

	// Method that adds colour to the fillMapleLeaf command
	public void fillLeaf(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a maple leaf
		c.fillMapleLeaf(x, y, width, height);
	}

	// Moon Method
	public void moon() {
		// Animation that ends when star finishes
		while (!MyCreation.end) {
			// Move to the left loop
			for (int x = 0; x <= 20; x++) {
				// Erase
				fillBox(520 - x, 20, 102, 100, M.SKY);

				// Main Moon
				fillOval(520 - x, 20, 100, 100, M.GREEN);

				// Makes moon crescent
				fillOval(500 - x, 0, 100, 100, M.SKY);

				// Internal Leaf
				fillLeaf(560 - x, 60, 20, 20, M.NAVY);

				// Internal Star
				fillStar(540 - x, 40, 20, 20, M.FUCHSIA);

				// Internal Square
				fillBox(535 - x, 62, 11, 11, M.OLIVE);

				// Delay of 1/60 of a second
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
				}
			}

			// Move to the right loop
			for (int x = 0; x <= 20; x++) {
				// Erase
				fillBox(520 - 20 + x, 20, 102, 100, M.SKY);

				// Main Moon
				fillOval(520 - 20 + x, 20, 100, 100, M.GREEN);

				// Makes moon crescent
				fillOval(500 - 20 + x, 0, 100, 100, M.SKY);

				// Internal Leaf
				fillLeaf(560 - 20 + x, 60, 20, 20, M.NAVY);

				// Internal Star
				fillStar(540 - 20 + x, 40, 20, 20, M.FUCHSIA);

				// Internal Square
				fillBox(535 - 20 + x, 62, 11, 11, M.OLIVE);

				// Delay of 1/60 of a second
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	// Class Constructor
	public Moon(Console c) {
		this.c = c;
	}

	// Run Method
	public void run() {
		moon();
	}

}