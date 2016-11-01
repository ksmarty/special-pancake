package myCreation;
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/10/2016
 *Tree Class
 */

import java.awt.Color;

import hsa.Console;

public class Tree extends Thread {
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

	// Method that adds colour to the fillLeaf command
	public void fillLeaf(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Draws a leaf
		c.fillMapleLeaf(x, y, width, height);
	}

	public void tree() {
		// Tree Trunk
		fillBox(300, 380, 20, 60, M.MAROON);

		// Middle section of the tree
		for (int x = 0; x <= 19; x++) {
			// Draws an angled trunk that resembles a tree
			drawLine(300 + x, 380, 320 + x, 340, M.MAROON);
		}

		// Top section of the tree
		for (int x = 0; x <= 19; x++) {
			// Draws an angled trunk that resembles a tree
			drawLine(339 - x, 340, 320 - x, 280, M.MAROON);
		}

		// Draws the Maple Leaf
		fillLeaf(310, 260, 20, 20, M.GREEN);

		// Erase 2 x coordinates
		int[] xPoints = { 320, 340, 356 };
		// Erase 2 y coordinates
		int[] yPoints = { 380, 340, 355 };

		// Erase 3 x coordinates
		int[] xPoints1 = { 339, 320, 356 };
		// Erase 3 y coordinates
		int[] yPoints1 = { 340, 280, 330 };

		// Animation that ends when star finishes
		while (!MyCreation.end) {
			// Branches extend loop
			for (int x = 0; x <= 10; x++) {
				// Erase 1
				fillBox(280, 380, 20, 32, M.SKY);

				// Lowest Branch - 2px thick
				drawLine(300, 380, 280, 400 + x, M.MAROON);
				drawLine(301, 380, 280, 401 + x, M.MAROON);

				// Erase 2
				c.setColor(M.SKY);
				c.fillPolygon(xPoints, yPoints, 3);

				// Middle Branch
				drawLine(330, 360, 345 + x, 355, M.MAROON);

				// Erase 3
				c.setColor(M.SKY);
				c.fillPolygon(xPoints1, yPoints1, 3);

				// Top Branch
				drawArc(310, 300, 30 - x, 30, 0, 90, M.MAROON);

				// Delay of 1/60 of a second
				try {
					Thread.sleep(75);
				} catch (InterruptedException e) {
				}
			}

			// Branches contract loop
			for (int x = 0; x <= 10; x++) {
				// Erase 1
				fillBox(280, 380, 20, 32, M.SKY);

				// Lowest Branch - 2px thick
				drawLine(300, 380, 280, 410 - x, M.MAROON);
				drawLine(301, 380, 280, 411 - x, M.MAROON);

				// Erase 2
				c.setColor(M.SKY);
				c.fillPolygon(xPoints, yPoints, 3);

				// Middle Branch
				drawLine(330, 360, 355 - x, 355, M.MAROON);

				// Erase 3
				c.setColor(M.SKY);
				c.fillPolygon(xPoints1, yPoints1, 3);

				// Top Branch
				drawArc(310, 300, 20 + x, 30, 0, 90, M.MAROON);

				// Delay of 1/60 of a second
				try {
					Thread.sleep(75);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	// Class Constructor
	public Tree(Console c) {
		this.c = c;
	}

	// Run Method
	public void run() {
		tree();
	}

}