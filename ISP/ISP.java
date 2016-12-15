import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import hsa.Console;
/*-
 * Kyle Schwartz
 * Mrs. Krasteva
 * January, 2017
 * Snake! My ISP that allows you to play the classic game snake.
 */
/*-****************************************************************************************
 * Variables 
 * Name			Type		Description
 * ---------------------------------------------------------------------------------------
 * option		char		Stores the user's menu choice
 * font			Font		Stores the font used on all screens
 * snakeX		LinkedList	Stores all of the snake X positions
 * snakeY		LinkedList	Stores all of the snake Y positions
 * key			char		Stores the user's ASCII key presses
 * ke			KeyEvent	Stores the user's arrow key presses
 * fruit		int[]		Stores the x & y coordinates of the fruit and whether a new one should be generated
 * newMove		int			Checks if the user is allowed to move and quits the game
 *****************************************************************************************/

public class ISP {
	static Console c;
	char option;
	Font font;
	LinkedList snakeX = new LinkedList();
	LinkedList snakeY = new LinkedList();
	char key;
	KeyEvent ke;
	int[] fruit = new int[3];
	int newMove;

	/*-****************************************************************************************
	 * ISP
	 * This method is the class constructor and sets up the main font.
	 * 
	 * Variables 
	 * Name			Type		Description
	 * font			Font		Stores the font used on all screens
	 * c			Console		Stores the console instance
	 * key			char		Gets the user's ASCII key presses
	 * ke			KeyEvent	Gets the users key presses
	 *****************************************************************************************/
	public ISP() {
		c = new Console(25, 78, "Snake! - Kyle Schwartz's ISP");
		// Sets up the font
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("isp.ttf"));
		} catch (FileNotFoundException e) {
		} catch (FontFormatException e) {
		} catch (IOException e) {
		}

		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			public void eventDispatched(AWTEvent awte) {
				ke = (KeyEvent) awte;
				if (!ke.getComponent().getName().equals("canvas0"))
					return;
				if (KeyEvent.KEY_PRESSED == ke.getID())
					key = ke.getKeyChar();
			}
		}, AWTEvent.KEY_EVENT_MASK);
	}

	/*-****************************************************************************************
	 * key
	 * This method sets the direction that the snake is going to move
	 *****************************************************************************************/
	private int movement(int score) {
		// Checks if the user is allowed to move
		if (newMove == 1) {
			// Allows the user only 1 move and updates the lists
			newMove = 2;

			// Moves the snake forward one position
			for (int x = snakeX.size() - 1; x > 0; x--) {
				snakeX.set(x, snakeX.get(x - 1));
				snakeY.set(x, snakeY.get(x - 1));
			}

			// Checks if the user pressed 'a'
			if (key == 'a' || ke.getKeyCode() == KeyEvent.VK_LEFT) {
				// Moves the snake's head to the left
				snakeX.set(0, Integer.toString(Integer.parseInt((String) snakeX.getFirst()) - 25));
				// Checks if the user pressed 's'
			} else if (key == 's' || ke.getKeyCode() == KeyEvent.VK_DOWN) {
				// Moves the snake's head down
				snakeY.set(0, Integer.toString(Integer.parseInt((String) snakeY.getFirst()) + 25));
				// Checks if the user pressed 'd'
			} else if (key == 'd' || ke.getKeyCode() == KeyEvent.VK_RIGHT) {
				// Moves the snake's head right
				snakeX.set(0, Integer.toString(Integer.parseInt((String) snakeX.getFirst()) + 25));
				// Checks if the user pressed 'w'
			} else if (key == 'w' || ke.getKeyCode() == KeyEvent.VK_UP) {
				// Moves the snake's head up
				snakeY.set(0, Integer.toString(Integer.parseInt((String) snakeY.getFirst()) - 25));
				// Checks if the user pressed ESC
			} else if (key == 27)
				// Breaks another loop sending the user back to main menu
				newMove = 0;

			// Checks to see if the snake is touching an edge
			if (Integer.parseInt((String) snakeX.getFirst()) < 0 || Integer.parseInt((String) snakeX.getFirst()) > 600
					|| Integer.parseInt((String) snakeY.getFirst()) < 50
					|| Integer.parseInt((String) snakeY.getFirst()) > 500)
				// Tells the program to exit
				newMove = 0;

			// Stops snake from touching itself
			if (score != 1) {
				for (int z = snakeX.size() - 2; z > 0; z--) {
					if (Integer.parseInt((String) snakeX.getFirst()) == Integer.parseInt((String) snakeX.get(z))
							&& Integer.parseInt((String) snakeY.getFirst()) == Integer.parseInt((String) snakeY.get(z)))
						newMove = 0;
				}
			}

			// Checks to see if the snake is touching the fruit
			for (int b = 0; b < snakeX.size() - 1; b++) {
				if (Integer.parseInt((String) snakeX.get(b)) == fruit[1]
						&& Integer.parseInt((String) snakeY.get(b)) == fruit[2]) {
					// Removes the last x position that is used for erasing
					snakeX.removeLast();
					// Removes the last x position that is used for erasing
					snakeY.removeLast();
					// Adds 4 if the users score is only 1
					if (score == 1) {
						for (int x = 0; x < 5; x++) {
							snakeX.addLast(Integer.toString(fruit[1]));
							snakeY.addLast(Integer.toString(fruit[2]));
						}
						// Adds 4 otherwise
					} else {
						for (int x = 0; x < 6; x++) {
							snakeX.addLast(Integer.toString(fruit[1]));
							snakeY.addLast(Integer.toString(fruit[2]));
						}
					}
					// Sets the background colour
					c.setColor(Color.decode("#8BC34A"));
					// Draws the background
					c.fillRect(0, 50, 640, 500);
					fruit[0] = 1;
					// Makes a new fruit X
					fruit[1] = (1 + (int) (Math.random() * 24)) * 25;
					// Makes a new fruit Y
					fruit[2] = (1 + (int) (Math.random() * 16)) * 25 + 50;
					// Sets fruit colour
					c.setColor(Color.decode("#0000FF"));
					// Draws fruit
					c.fillRect(fruit[1], fruit[2], 25, 25);
					// Declares that a new fruit should not be generated
					fruit[0] = 2;
					/*- Breaks the loop to prevent memory leak & unneeded processing */
					break;
				}
			}
		}

		// Sets the user's speed based on score
		while (score != 90) {
			return 1000 - score * 10;
		}
		return 100;
	}

	/*-****************************************************************************************
	 * snake
	 * This method 
	 * 
	 * Variables 
	 * Name			Type		Description
	 * 
	 *****************************************************************************************/
	public void snake() {
		fruit[0] = 1;
		int score = 1;
		newMove = 1;

		snakeX.clear();
		snakeY.clear();

		snakeX.add("100");
		snakeY.add("100");
		snakeX.add("100");
		snakeY.add("100");

		// Sets the background colour
		c.setColor(Color.decode("#8BC34A"));
		// Draws the background
		c.fillRect(0, 0, 640, 500);
		// Sets the top bar colour
		c.setColor(Color.decode("#689F38"));
		// Draws the top bar
		c.fillRect(0, 0, 640, 50);
		int x = movement(score);
		// Makes a new fruit X
		fruit[1] = (1 + (int) (Math.random() * 24)) * 25;
		// Makes a new fruit Y
		fruit[2] = (1 + (int) (Math.random() * 16)) * 25 + 50;
		// Sets fruit colour
		c.setColor(Color.decode("#0000FF"));
		// Draws fruit
		c.fillRect(fruit[1], fruit[2], 25, 25);
		// Declares that a new fruit should not be generated
		fruit[0] = 2;

		while (newMove != 0) {
			// Updates score
			score = snakeX.size() - 1;
			// Sets top bar colour
			c.setColor(Color.decode("#689F38"));
			// Draws the background
			c.fillRect(0, 0, 640, 50);
			// Set score colour
			c.setColor(Color.decode("#212121"));
			// Sets score font
			c.setFont(font.deriveFont(46f));
			// Draws score
			c.drawString("Score: " + score, 10, 45);
			// Draws Speed
			c.drawString("Speed: " + (1000 - x), 350, 45);
			// Sets erase colour to the background colour
			c.setColor(Color.decode("#8BC34A"));
			// Erases last position
			c.fillRect(Integer.parseInt((String) snakeX.getLast()), Integer.parseInt((String) snakeY.getLast()), 25,
					25);
			// Sets snake colour
			c.setColor(Color.decode("#FF4500"));
			// Draws the snake
			for (int a = 0; a < snakeX.size() - 1; a++)
				c.fillRoundRect(Integer.parseInt((String) snakeX.get(a)), Integer.parseInt((String) snakeY.get(a)), 25,
						25, 10, 10);
			// Allows the user to enter a direction
			newMove = 1;
			try {
				Thread.sleep(x);
			} catch (InterruptedException e) {
			}
			x = movement(score);

		}
		// Highscore Checking
		try {
			scoreChecker(score);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	private void scoreChecker(int score) throws FileNotFoundException, IOException {
		String[] players = new String[10];
		String[] scores = new String[10];
		String name = null;

		BufferedReader buffer = new BufferedReader(new FileReader(new File("leaderboard.dat")));
		for (int x = 0; x < 10; x++)
			players[x] = buffer.readLine();
		for (int x = 0; x < 10; x++)
			scores[x] = buffer.readLine();
		buffer.close();

		for (int x = 0; x < 10; x++) {
			if (score > Integer.parseInt(scores[x])) {
				while (name == null || name.length() > 20)
					name = JOptionPane.showInputDialog(null, "Please enter your name (20 characters or less):",
							"Congratulations! New high score!", JOptionPane.QUESTION_MESSAGE);
				players[x] = name;
				scores[x] = Integer.toString(score);

				PrintWriter output = new PrintWriter(new FileWriter("leaderboard.dat"));
				for (int z = 0; z < 10; z++)
					output.println(players[z]);
				for (int z = 0; z < 10; z++)
					output.println(scores[z]);
				output.close();

				break;
			}
		}
		if (name == null && key != 27)
			JOptionPane.showMessageDialog(null, "You died. Better luck next time!", "Good Job. You tried your best!",
					JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "We hope you come back soon!", "Play again",
					JOptionPane.WARNING_MESSAGE);
	}

	/*-****************************************************************************************
	 * title
	 * This method draws a green background as well as the title.
	 *****************************************************************************************/

	private void title() {
		c.clear();
		// Sets the background colour
		c.setColor(Color.decode("#8BC34A"));
		// Draws the background
		c.fillRect(0, 0, 640, 500);
		// Sets the colour to gray
		c.setColor(Color.decode("#212121"));
		// Uses the imported font
		c.setFont(font.deriveFont(100f));
		// Draws the title
		c.drawString("Snake!", 150, 90);
	}

	/*-****************************************************************************************
	 * pauseProgram
	 * This method pauses the program and waits for the user to press a key.
	 *****************************************************************************************/
	private void pauseProgram(int x) {
		String y = null;
		// Sets the colour to gray
		c.setColor(Color.decode("#212121"));
		// Uses the imported font
		c.setFont(font.deriveFont(30f));
		// Checks if to exit or continue
		if (x == 1)
			y = "continue";
		else if (x == 2)
			y = "exit";
		// Prompts the user to press a key
		c.drawString("Press any key to " + y + "...", 10, 480);
		// Waits for user input
		c.getChar();
	}

	public void goodBye() {
		title();

		c.setFont(font.deriveFont(40f));
		c.drawString("Thank you for playing ", 10, 200);
		c.drawString("Snake! This program was ", 10, 240);
		c.drawString("made by Kyle Schwartz.", 10, 280);

		pauseProgram(2);
		c.close();
	}

	public void instructions() {
		title();
		c.setFont(font.deriveFont(30f));

		c.drawString("Use W, A, S, D or Up, Down, Left, Right", 10, 210);
		c.drawString("to move the snake. Eat the fruit to", 10, 240);
		c.drawString("grow and go faster. Never run into", 10, 270);
		c.drawString("yourself or the edge, or you'll die.", 10, 300);
		c.drawString("Have Fun!", 10, 330);

		pauseProgram(1);
	}

	public void mainMenu() {
		title();

		c.setFont(font.deriveFont(50f));
		int x = 210;
		c.drawString("1. Play", 27, x);
		c.drawString("2. Instructions", 21, x + 50);
		c.drawString("3. Leaderboard", 25, x + 100);
		c.drawString("4. Quit", 20, x + 150);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		option = c.getChar();
	}

	public void splashScreen() {
		c.clear();
		c.setFont(font.deriveFont(100f));
		c.setColor(Color.decode("#8BC34A"));
		for (int x = -350; x < 0; x++) {
			c.setColor(Color.decode("#8BC34A"));
			c.fillRect(0, 0, 800, 600);

			c.setColor(Color.decode("#212121"));
			c.drawString("SCHWARTZ", 55, 210 + x);
			c.drawString("STUDIOS", 95, 310 + x);
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void leaderboard() throws FileNotFoundException, IOException {
		title();

		String[] players = new String[10];
		String[] scores = new String[10];

		BufferedReader buffer = new BufferedReader(new FileReader(new File("leaderboard.dat")));
		for (int x = 0; x < 10; x++)
			players[x] = buffer.readLine();
		for (int x = 0; x < 10; x++)
			scores[x] = buffer.readLine();
		buffer.close();

		c.setFont(font.deriveFont(30f));
		c.drawString("Press 'c' to clear the high scores.", 10, 120);
		c.drawLine(10, 124, 580, 124);
		String y;
		String z;
		for (int x = 0; x < 10; x++) {
			if (players[x].equals("null")) {
				y = "";
				z = "";
			} else {
				y = players[x] + ": ";
				z = scores[x];
			}

			c.drawString(y + z, 10, 150 + x * 30);
		}

		pauseProgram(1);

		if (key == 'c') {
			PrintWriter output = new PrintWriter(new FileWriter("leaderboard.dat"));
			for (int a = 0; a < 10; a++)
				output.println("null");
			for (int a = 0; a < 10; a++)
				output.println("0");
			output.close();
			leaderboard();
		}
	}

	public static void main(String[] args) {
		ISP i = new ISP();
		// i.splashScreen();
		while (true) {
			i.mainMenu();
			if (i.option == '1')
				i.snake();
			else if (i.option == '2')
				i.instructions();
			else if (i.option == '3')
				try {
					i.leaderboard();
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
				}
			else if (i.option == '4') {
				Object[] options = { "Yes, I want to leave and feel sad.", "No way! I want to play more!" };
				int result = JOptionPane.showOptionDialog(null,
						"Would you like to leave and not continue playing an amazing game??", "A Silly Question",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (result == JOptionPane.YES_OPTION)
					break;
			} else if (i.option == '\u0000') {
			} else {
				JOptionPane.showMessageDialog(null, "That's not a valid input! Press OK to continue.",
						"You've Made A Horrible Life Choice", JOptionPane.ERROR_MESSAGE);
			}

		}
		i.goodBye();
	}
}
