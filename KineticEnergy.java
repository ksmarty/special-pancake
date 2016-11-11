
/*Kyle Schwartz
 *Mrs. Krasteva
 *07/11/2016
 *Assignment 11
 */
import java.awt.Color;

import hsa.Console;
import hsa.Message;

public class KineticEnergy {
	Console c;
	// Declarations
	// vhoice - Char - Stores the user's choice
	// energy - Double - Stores the final value of energy
	// mass - Double - Stores the final value of mass
	// velo - Double - Stores the final value of velocity
	// s - Char - Stores the Squared symbol
	char choice;
	double energy, mass, velo;
	char s = 178;

	public KineticEnergy() {
		c = new Console("Kinetic Energy Calculator");
	} // Class constructor

	/*
	 * Draw Title Method
	 * 
	 * This clears the screen and prints the title with a blank line below
	 */
	private void drawTitle() {
		c.clear();
		c.println("Kinetic Energy Calculator\n");

	}

	/*
	 * Pause Program Method
	 * 
	 * Prompts the user to enter any get to continue
	 */
	private void pauseProgram() {
		c.println("\nPress any key to continue...");
		c.getChar();
	}

	/*
	 * Intro Method
	 * 
	 * Gives the user a description of the program as well as the equation.
	 */
	public void intro() {
		drawTitle();
		c.println("This program will solve for any missing value in the kinetic energy equation.");
		c.println("The equation is KE = 1/2 (MV" + s + ")");
		c.println("\nPress c to continue or any other key to exit...");
		c.setColor(Color.RED);
		c.fillOval(60, 400, 70, 70);
		c.setColor(Color.black);
		c.drawArc(60, 385, 70, 55, 0, 160);
		c.drawLine(61, 404, 60, 390);
		c.drawLine(61, 404, 75, 395);
		choice = c.getChar();

	}

	/*
	 * Ask Data Method
	 * 
	 * Asks the user which variable they want to solve for.
	 * 
	 * The if statement determines what the user input and if it is valid to
	 * proceed. Otherwise it denies the user and prompts them to try again.
	 */
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
			c.print("Please enter the value of Mass: ");
			mass = c.readDouble();

			c.println();

			c.print("Please enter the value of Kinetic Energy: ");
			energy = c.readDouble();

		} else {
			new Message("That is not a valid input. Press OK to try again.");
			askData();
		}
		pauseProgram();
	}

	/*
	 * Display Data Method
	 * 
	 * Outputs the solved variable as well as the full equation.
	 * 
	 * The if statement solves the desired variable based on the user's choice
	 * from askData()
	 * 
	 * The nested while statement square roots 2 * energy / mass.
	 * 
	 * found - String - Stores the name of the solved variable.
	 * 
	 * found2 - Double - Stores the value of the solved variable.
	 */
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
			double v = 2 * energy / mass;
			double sq = v;
			double sqrt = sq / 2.0;
			double lastsqrt = 0.0;
			while (sqrt != lastsqrt) {
				lastsqrt = sqrt;
				sqrt = (lastsqrt + sq / lastsqrt) / 2;
			}
			velo = sqrt;
			found = "velocity";
			found2 = velo;
		}
		c.println("The value of " + found + " is " + found2);
		c.println("So that brings the final formula to " + energy + " = 1/2 (" + mass + " * " + velo + s + ")");
		pauseProgram();
	}

	/*
	 * Bye Method
	 * 
	 * Thanks the user for using the program and quits after 5 seconds.
	 * 
	 * The for loop counts to 5 with a 1 second delay before running again.
	 */
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

	/*
	 * Main Method
	 * 
	 * Runs the whole program
	 * 
	 * The if statement determines if the user wants to continue or exit the
	 * program.
	 */
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
