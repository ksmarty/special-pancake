package myCreation;
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/10/2016
 *Cross Class
 */

//Imports
import java.awt.Color;

import hsa.Console;

public class Cross extends Thread {
	private Console c;

	// Method that adds colour to the fillRect command
	public void fillBox(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a rectangle
		c.fillRect(x, y, width, height);
	}

	// Method that adds colour to the drawLine command
	public void drawLine(int x1, int y1, int x2, int y2, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a line
		c.drawLine(x1, y1, x2, y2);
	}

	// Method that adds colour to the drawArc command
	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws an arc
		c.drawArc(x, y, width, height, startAngle, arcAngle);
	}

	// Method that adds colour to the drawOval command
	public void drawOval(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws an oval
		c.drawOval(x, y, width, height);
	}

	public void cross() {
		// Animation that ends when star finishes
		while (!MyCreation.end) {
			// Jump Up Loop
			for (int y = 0; y <= 30; y++) {
				// Erase
				fillBox(120, 340 - y, 60, 100, M.SKY);

				// Main Cross
				fillBox(120, 380 - y, 60, 20, M.CROSS);
				fillBox(140, 360 - y, 20, 79, M.CROSS);

				// Top Circle
				drawOval(140, 340 - y, 20, 20, M.CROSS);

				// Cross Oranament
				drawLine(150, 360 - y, 150, 343 - y, M.CROSS);
				drawLine(145, 348 - y, 155, 348 - y, M.CROSS);

				// Middle Arc
				drawArc(140, 390 - y, 20, 20, 0, 180, Color.BLACK);

				// Delay of 1/60 of a second
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
				}
			}
			// Falling Loop
			for (int y = 0; y <= 30; y++) {
				// Erase
				fillBox(120, 339 - 30 + y, 60, 100, M.SKY);

				// Main Cross
				fillBox(120, 380 - 30 + y, 60, 20, M.CROSS);
				fillBox(140, 360 - 30 + y, 20, 79, M.CROSS);

				// Top Circle
				drawOval(140, 340 - 30 + y, 20, 20, M.CROSS);

				// Cross Oranament
				drawLine(150, 360 - 30 + y, 150, 343 - 30 + y, M.CROSS);
				drawLine(145, 348 - 30 + y, 155, 348 - 30 + y, M.CROSS);

				// Middle Arc
				drawArc(140, 390 - 30 + y, 20, 20, 0, 180, Color.BLACK);

				// Delay of 1/60 of a second
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	// Class Constructor
	public Cross(Console c) {
		this.c = c;
	}

	// Run Method
	public void run() {
		cross();
	}

}