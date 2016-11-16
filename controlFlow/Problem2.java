package controlFlow;

import hsa.Console;

/*
 * Lev Kropp & Kyle Schwartz
 * Problem #2
 * Ms Krasteva
 * 10/11/16
 */

public class Problem2 {
	Console c;

	String[] studentName;

	long[] studentNumber;

	short[] studentMark;

	public Problem2() {
		c = new Console();

	}

	public static void main(String[] args) {
		Problem2 t = new Problem2();

		t.askData();
		t.display();
	}

	public void display() {
		c.println("Processing..");

		double average = 0;

		for (int i = 0; i < studentName.length; i++) {
			average += studentMark[i];
		}

		average /= studentName.length;

		c.println("The average mark is: " + average);
		c.println("\nPress any key to exit..");
		c.getChar();
		c.close();

	}

	public void askData() {

		c.println("How many students would you like to enter marks for?");
		int amount = readInputInt(c.readLine());

		studentName = new String[amount];

		studentNumber = new long[amount];

		studentMark = new short[amount];

		for (int i = 0; i < amount; i++) {
			c.println("What is student " + (i + 1) + "'s name?");
			studentName[i] = readInputString(c.readLine());

			c.println("What is " + studentName[i] + "'s student number?");

			studentNumber[i] = readInputLong(c.readLine());

			c.println("What is student " + (i + 1) + "'s mark?");
			studentMark[i] = readInputShort(c.readLine());

		}
	}

	private int readInputInt(String data) {

		int temp;
		if (data.equals("end") || data.equals("-1")) {
			c.close();
		}

		try {
			temp = Integer.parseInt(data);
			return temp;
		} catch (Exception e) {
			c.println("That's not a valid input!");
			readInputInt(c.readLine());
		}
		return 0;

	}

	private long readInputLong(String data) {

		long temp;
		if (data.equals("end") || data.equals("-1")) {
			c.close();
		}

		try {
			temp = Long.parseLong(data);
			return temp;
		} catch (Exception e) {
			c.println("That's not a valid input!");
			readInputLong(c.readLine());
		}
		return 0;

	}

	private short readInputShort(String data) {

		short temp;

		if (data.equals("end") || data.equals("-1")) {
			c.close();
		}

		try {
			temp = Short.parseShort(data);

			if (temp < 0 || temp > 100) {
				c.println("That's not a valid mark!");
				readInputShort(c.readLine());
			} else {
				return temp;
			}

		} catch (Exception e) {
			c.println("That's not a valid input!");
			readInputShort(c.readLine());
		}
		return 0;

	}

	private String readInputString(String data) {

		if (data.equals("end") || data.equals("-1")) {
			c.close();
		}
		return data;

	}

}