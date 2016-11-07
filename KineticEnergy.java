
/*Kyle Schwartz
 *Mrs. Krasteva
 *04/11/2016
 *Assignment 11
 */
import java.awt.Color;
import java.awt.Font;

import hsa.Console;
import hsa.Message;

public class KineticEnergy {
	Console c;
	char choice;
	double energy;
	double mass;
	double velo;
	char s = 178;

	public KineticEnergy() {
		c = new Console("Kinetic Energy Calculator");
	} // Class constructor

	private void drawTitle() {
		c.clear();
		c.println("\n\n");
		Font plainFont = new Font("Sans-Serif", Font.BOLD, 24);
		c.setFont(plainFont);
		c.setColor(Color.black);
		c.drawString("Kinetic Energy Calculator", 180, 33);

	}

	private void pauseProgram() {
		c.println("Press c to continue or any other key to exit...");
		choice = c.getChar();
	}

	public void intro() {
		drawTitle();
		c.println("This program will solve for any missing value in the kinetic energy equation.");
		c.println("The equation is KE = 1/2 (MV" + s + ")");
		pauseProgram();
	}

	public void askData() {
		drawTitle();
		c.println("Would you like to solve for K, M or V?");
		c.println();
		choice = c.getChar();
		if (choice == 'k' || choice == 'K') {
			c.print("Please enter the value of Mass: ");
			mass = c.readDouble();
			c.println();

			c.print("Please enter the value of Velocity: ");
			velo = c.readDouble();

		} else if (choice == 'm' || choice == 'M') {
			c.print("Please enter the value of Kinetic Energy: ");
			energy = c.readDouble();
			c.println();

			c.print("Please enter the value of Velocity: ");
			velo = c.readDouble();

		} else if (choice == 'v' || choice == 'V') {
			c.print("Please enter the value of Kinetic Energy: ");
			mass = c.readDouble();
			c.println();

			c.print("Please enter the value of Mass: ");
			energy = c.readDouble();

		} else {
			new Message("That is not a valid input. Press any key to try again.");
			c.getChar();
			askData();
		}

	}

	public void displayData() {
		drawTitle();
		String found = null;
		double found2 = 0;

		if (choice == 'k' || choice == 'K') {
			energy = 0.5 * (mass * (velo * velo));
			found = "energy";
			found2 = energy;

		} else if (choice == 'm' || choice == 'M') {
			mass = 2 * energy / (velo * velo);
			found = "mass";
			found2 = mass;

		} else if (choice == 'v' || choice == 'V') {
			double sq = 2 * energy / mass;
			double sqrt = sq / 2;
			double lastsqrt = 0.0;
			while (sqrt != lastsqrt) {
				lastsqrt = sqrt;
				sqrt = (lastsqrt + sq / lastsqrt) / 2;
			}
			velo = sqrt * 10;
			found = "velocity";
			found2 = velo;
		}
		c.println("The value of " + found + " is " + found2);
		c.println("So that brings the final formula to " + energy + " = 1/2 (" + mass + " * " + velo + s + ")");
		c.getChar();
	}

	public void bye() {
		drawTitle();
		c.println("Thanks for using my program, Kinetic Energy Calculator!");
		c.print("This program will quit in 5..");
		for (int x = 4; x >= 0; x--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			c.print(x + "..");
		}
		c.close();
	}

	public static void main(String[] args) {
		KineticEnergy k = new KineticEnergy();
		k.intro();
		if (k.choice == 'c' || k.choice == 'C') {
			k.askData();
			k.displayData();
		}
		k.bye();
	}
}
