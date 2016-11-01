package myCreation;
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/10/2016
 *Star Class
 */

import java.awt.Color;

import hsa.Console;

public class Star extends Thread {
	private Console c;

	// Method that adds colour to the fillStar command
	public void fillStar(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a star
		c.fillStar(x, y, width, height);
	}

	// Method that adds colour to the drawOval command
	public void drawOval(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws an oval
		c.drawOval(x, y, width, height);
	}

	// Method that adds colour to the drawLine command and makes it a dot
	public void drawDot(int x, int y, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a line
		c.drawLine(x, y, x, y);
	}

	// Method that adds colour to the fillRect command
	public void fillBox(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a rectangle
		c.fillRect(x, y, width, height);
	}

	// Star Method
	public void star() {
		// Starting x
		int x = 666;

		// Starting Y
		int y = 160;

		// Animation Loop
		for (int j = 1; j <= 792; j++) {
			// Erase Command
			fillBox(x - 26 - j, y - 5, 153, 31, M.SKY);

			// Outer Circle
			drawOval(x - 5 - j, y - 5, 30, 30, M.FUCHSIA);

			// Star
			fillStar(x - j, y, 20, 20, M.BLACK);

			// Front Arc
			c.setColor(M.FUCHSIA);
			c.drawArc(x - 26 - j, y, 20, 20, 270, 180);

			// Dust Trail
			for (int g = 1; g <= 30; g++) {
				// Random x coordinate
				int starX = (int) (Math.random() * (((x + 125) - (x + 30)) + 1)) + x + 30;

				// Random y coordinate
				int starY = (int) (Math.random() * ((y - (y + 20)) + 1)) + y + 20;

				// Draw dust
				drawDot(starX - j, starY, M.BLACK);
			}

			// Delay for 1/60 of a second
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
			}
		}

	}

	// Class Constructor
	public Star(Console c) {
		this.c = c;
	}

	// Run Method
	public void run() {
		star();
		// Declares that the animations will now conclude
		MyCreation.end = true;
	}

}
