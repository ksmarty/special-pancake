package myCreation;
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/10/2016
 *Pumpkin Class
 */

import java.awt.Color;

import hsa.Console;

public class Pumpkin extends Thread {
	private Console c;
	// Int delay determines how long of a delay the last overload will have
	static int delay;

	// Starting x coordinate
	int x;

	// Starting y coordinate
	int y;

	// Pumpkin colour
	Color n;

	// Method that adds colour to the fillRect command
	public void fillBox(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a rectangle
		c.fillRect(x, y, width, height);
	}

	// Method that adds colour to the drawLine command
	public void drawLine(int x, int y, int x2, int y2, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a line
		c.drawLine(x, y, x2, y2);
	}

	// Method that adds colour to the drawArc command
	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws an arc
		c.drawArc(x, y, width, height, startAngle, arcAngle);
	}

	// Method that adds colour to the fillOval command
	public void fillOval(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws an oval
		c.fillOval(x, y, width, height);
	}

	// Method that adds colour to the drawStar command and draws a dot
	public void drawDot(int x, int y, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a star
		c.drawStar(x, y, 1, 1);
	}

	// Overloaded method 1
	public Pumpkin(Console c) {
		this.c = c;

		// Color
		n = M.PUMPKIN1;

		// Start x
		x = 640;

		// Start y
		y = 409;

	}

	// Overloaded method 2
	public Pumpkin(Console c, Color n) {
		this.c = c;

		// Color
		this.n = n;

		// Start x
		x = 710;

		// Start y
		y = 409;
	}

	// Overloaded method 3
	public Pumpkin(Console c, Color n, int t) {
		this.c = c;

		// Delay
		delay = t;

		// Color
		this.n = n;

		// Start x
		x = 780;

		// Start y
		y = 409;
	}

	public void pumpkin() {
		// Loop to move 70 pixels to the left
		for (int j = 0; j <= 70; j++) {
			// Erase
			fillBox(x - j, y - 7, 46, 38, M.SKY);

			// Loop to create the pumpkin stem
			for (int l = 0; l <= 6; l++) {
				drawLine(x - j + 20 + l, y + 3, x - j + 22 + l, y - 7, M.BLACK);
			}

			// Left half of pumpkin
			fillOval(x - j, y, 30, 30, n);

			// Right half of pumpkin
			fillOval(x - j + 15, y, 30, 30, n);

			// Left Eye
			fillOval(x - j + 8, y + 8, 8, 8, M.WHITE);

			// Right Eye
			fillOval(x - j + 30, y + 8, 8, 8, M.WHITE);

			// Left Pupil
			drawDot(x - j + 10, y + 10, M.BLACK);

			// Right Pupil
			drawDot(x - j + 32, y + 10, M.BLACK);

			// Smile
			drawArc(x - j + 13, y + 15, 20, 10, 180, 180, M.BLACK);

			// Delay for 1/60 of a second
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
			}
		}

		// Adjusts x to 70 less than before
		x -= 70;

		for (int j = 0; j <= 40; j++) {
			// Erase
			fillBox(x - j, y - 7 - j, 46, 38, M.SKY);

			// Loop to create the pumpkin stem
			for (int l = 0; l <= 6; l++) {
				drawLine(x - j + 20 + l, y + 3 - j, x - j + 22 + l, y - 7 - j, M.BLACK);
			}

			// Left half of pumpkin
			fillOval(x - j, y - j, 30, 30, n);

			// Right half of pumpkin
			fillOval(x - j + 15, y - j, 30, 30, n);

			// Left Eye
			fillOval(x - j + 8, y + 8 - j, 8, 8, M.WHITE);

			// Right Eye
			fillOval(x - j + 30, y + 8 - j, 8, 8, M.WHITE);

			// Left Pupil
			drawDot(x - j + 10, y + 10 - j, M.BLACK);

			// Right Pupil
			drawDot(x - j + 32, y + 10 - j, M.BLACK);

			// Smile
			drawArc(x - j + 13, y + 15 - j, 20, 10, 180, 180, M.BLACK);

			// Delay for 1/60 of a second
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
			}
		}

		// Adjusts x to 40 less than before
		x -= 40;
		// Adjusts y to 40 less than before
		y -= 40;

		for (int j = 0; j <= 40; j++) {
			// Erase
			fillBox(x - j, y - 8 + j, 46, 38, M.SKY);

			// Loop to create the pumpkin stem
			for (int l = 0; l <= 6; l++) {
				drawLine(x - j + 20 + l, y + 3 + j, x - j + 22 + l, y - 7 + j, M.BLACK);
			}

			// Left half of pumpkin
			fillOval(x - j, y + j, 30, 30, n);

			// Right half of pumpkin
			fillOval(x - j + 15, y + j, 30, 30, n);

			// Left Eye
			fillOval(x - j + 8, y + 8 + j, 8, 8, M.WHITE);

			// Right Eye
			fillOval(x - j + 30, y + 8 + j, 8, 8, M.WHITE);

			// Left Pupil
			drawDot(x - j + 10, y + 10 + j, M.BLACK);

			// Right Pupil
			drawDot(x - j + 32, y + 10 + j, M.BLACK);

			// Smile
			drawArc(x - j + 13, y + 15 + j, 20, 10, 180, 180, M.BLACK);

			// Delay for 1/60 of a second
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
			}
		}

		// Adjusts x to 40 less than before
		x -= 40;
		// Adjusts y to 40 more than before
		y += 40;

		for (int j = 0; j <= 40; j++) {
			// Erase
			fillBox(x - j, y - 7, 46, 38, M.SKY);

			// Loop to create the pumpkin stem
			for (int l = 0; l <= 6; l++) {
				drawLine(x - j + 20 + l, y + 3, x - j + 22 + l, y - 7, M.BLACK);
			}

			// Left half of pumpkin
			fillOval(x - j, y, 30, 30, n);

			// Right half of pumpkin
			fillOval(x - j + 15, y, 30, 30, n);

			// Left Eye
			fillOval(x - j + 8, y + 8, 8, 8, M.WHITE);

			// Right Eye
			fillOval(x - j + 30, y + 8, 8, 8, M.WHITE);

			// Left Pupil
			drawDot(x - j + 10, y + 10, M.BLACK);

			// Right Pupil
			drawDot(x - j + 32, y + 10, M.BLACK);

			// Smile
			drawArc(x - j + 13, y + 15, 20, 10, 180, 180, M.BLACK);

			// Delay for 1/60 of a second
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
			}
		}
	}

	// Run Method
	public void run() {
		pumpkin();
	}

}