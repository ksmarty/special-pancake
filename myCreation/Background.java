package myCreation;
/*Kyle Schwartz
 *Mrs. Krasteva
 *28/10/2016
 *Background Class
 */

//Imports
import java.awt.Color;

import hsa.Console;

public class Background {
	private Console c;

	// Method that adds colour to the drawRect command and fills the rectangles
	public void fillBox(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Loop to create filled rectangle
		for (int j = 1; j <= height; j++) {
			c.drawRect(x, y, width - j, height - j);
		}
	}

	// Method that adds colour to the drawArc command and fills the arcs
	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle, Color C) {
		// Sets colour
		c.setColor(C);
		// Loop to create filled arc
		for (int j = 1; j <= height; j++) {
			c.drawArc(x, y + j, width, height, startAngle, arcAngle);
		}
	}

	// Method that adds colour to the drawOval command and fills the ovals
	public void fillOval(int x, int y, int width, int height, Color C) {
		// Sets colour
		c.setColor(C);
		// Loop to create filled oval
		for (int j = 1; j <= x; j++) {
			c.drawOval(x + j / 2, y + j / 2, width - j, height - j);
		}
	}

	public void draw() {
		// Sky
		fillBox(0, 0, 640, 500, M.SKY);

		// Ground
		fillBox(0, 440, 640, 60, M.GROUND);

		// Tombstone 1
		fillBox(40, 400, 40, 40, M.TOMB);
		fillArc(40, 380, 40, 40, 0, 180, M.TOMB);

		// Cross 2
		fillBox(360, 380, 60, 20, M.CROSS);
		fillBox(380, 360, 20, 80, M.CROSS);

		// Cloud1
		// Bottom
		fillOval(100, 45, 30, 30, M.AUQA);
		fillOval(120, 50, 30, 30, M.RED);
		fillOval(140, 50, 30, 30, M.MAROON);
		fillOval(160, 47, 30, 30, M.YELLOW);
		// Top
		fillOval(110, 30, 30, 30, M.OLIVE);
		fillOval(130, 30, 30, 30, M.LIME);
		fillOval(150, 30, 30, 30, M.GREEN);

		// Cloud 2
		// Bottom
		fillOval(300, 45, 30, 30, M.TEAL);
		fillOval(320, 50, 30, 30, M.BLUE);
		fillOval(340, 50, 30, 30, M.NAVY);
		fillOval(360, 47, 30, 30, M.FUCHSIA);

		// Top
		fillOval(310, 30, 30, 30, M.PURPLE);
		fillOval(330, 30, 30, 30, M.TOMB);
		fillOval(350, 30, 30, 30, M.GROUND);
	}

	// Class Constructor
	public Background(Console c) {
		this.c = c;
		draw();
	}

}