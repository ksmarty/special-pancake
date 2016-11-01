package myCreation;
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/10/2016
 *Stone Class
 */

import java.awt.Color;

import hsa.Console;

public class Stone extends Thread {
	private Console c;
	M t = new M(c);

	// Method that adds colour to the fillRect command
	public void fillBox(int x, int y, int width, int height, Color color) {
		// Sets colour
		c.setColor(color);
		// Draws a rectangle
		c.fillRect(x, y, width, height);
	}

	// Method that adds colour to the fillArc command
	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws an arc
		c.fillArc(x, y, width, height, startAngle, arcAngle);
	}

	// Method that adds colour to the drawString command
	public void drawString(String str, int x, int y, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a string
		c.drawString(str, x, y);
	}

	private void stone() {
		// Begins the animation at a random time
		try {
			Thread.sleep((int) (Math.random() * 200 + 1));
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

		// Animation that ends when star finishes
		while (!MyCreation.end) {
			// Jump Up Loop
			for (int y = 0; y <= 30; y++) {
				// Erase
				fillBox(220, 359 - y, 40, 81, M.SKY);

				// Bottom of tomb
				fillBox(220, 399 - y, 40, 40, M.TOMB);

				// Top of tomb
				fillArc(220, 379 - y, 40, 40, 0, 180, M.TOMB);

				// Writes 'R.I.P'
				drawString("R.I.P.", 227, 405 - y, Color.BLACK);

				// Writes 'Kyle S.'
				drawString("Kyle S.", 223, 425 - y, Color.BLACK);

				// Draws a star at the top
				c.setColor(M.TOMB);
				c.drawStar(230, 360 - y, 20, 20);

				// Delay of 1/60 of a second
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
				}
			}
			// Falling Loop
			for (int y = 0; y <= 30; y++) {
				// Erase
				fillBox(220, 359 - 30 + y, 40, 81, M.SKY);

				// Bottom of tomb
				fillBox(220, 399 - 30 + y, 40, 40, M.TOMB);

				// Top of tomb
				fillArc(220, 379 - 30 + y, 40, 40, 0, 180, M.TOMB);

				// Writes 'R.I.P'
				drawString("R.I.P.", 227, 405 - 30 + y, Color.BLACK);

				// Writes 'Kyle S.'
				drawString("Kyle S.", 223, 425 - 30 + y, Color.BLACK);

				// Draws a star at the top
				c.setColor(M.TOMB);
				c.drawStar(230, 360 - 30 + y, 20, 20);

				// Delay of 1/60 of a second
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
				}
			}
		}

	}

	// Class Constructor
	public Stone(Console c) {
		this.c = c;
	}

	// Run Method
	public void run() {
		stone();
	}

}