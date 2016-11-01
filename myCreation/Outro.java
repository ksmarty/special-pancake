package myCreation;
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/10/2016
 *Outro Class
 */

import java.awt.Color;
import java.awt.Font;

import hsa.Console;

public class Outro implements Runnable {
	private Console c;
	M t = new M(c);

	// Adds colour to the fillRect command
	public void fillBox(int x, int y, int width, int height, Color color) {
		// Sets colour
		c.setColor(color);
		// Draws a rectangle
		c.fillRect(x, y, width, height);
	}

	// Adds colour to the drawString command
	public void drawString(String str, int x, int y, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a string
		c.drawString(str, x, y);
	}

	private void outro() {
		// Delays for 2 seconds until the animations stop
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		// Fills the background
		fillBox(0, 0, 640, 500, M.BLACK);

		// Writes "The End!"
		c.setFont(new Font("Calibri", 1, 30));
		drawString("The End!", 275, 250, M.WHITE);

	}

	// Class Constructor
	public Outro(Console c) {
		this.c = c;
	}

	// Run Method
	public void run() {
		outro();
	}

}