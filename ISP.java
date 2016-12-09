import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import hsa.Console;

public class ISP {
	static Console c;
	char option;
	Font font;

	public ISP() {
		c = new Console("Snake! - Kyle Schwartz's ISP");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("isp.ttf"));
		} catch (FileNotFoundException e) {
		} catch (FontFormatException e) {
		} catch (IOException e) {
		}
	} // Class constructor

	private void title() {
		c.clear();

		c.setColor(Color.decode("#8BC34A"));
		c.fillRect(0, 0, 800, 600);

		c.setColor(Color.decode("#212121"));
		c.setFont(font.deriveFont(100f));
		c.drawString("Snake!", 150, 90);
	}

	private void pauseProgram() {
		c.setColor(Color.decode("#212121"));
		c.setFont(font.deriveFont(30f));
		c.drawString("Press any key to continue...", 10, 480);
		c.getChar();
	}

	public void goodBye() {
		title();

		c.setFont(font.deriveFont(40f));
		c.drawString("Thank you for playing ", 10, 200);
		c.drawString("Snake! This program was ", 10, 240);
		c.drawString("made by Kyle Schwartz.", 10, 280);

		pauseProgram();
		c.close();
	}

	public void instructions() {
		title();
		c.setFont(font.deriveFont(30f));

		c.drawString("Use W, A, S, D to move the snake.", 10, 210);
		c.drawString("Eat the fruit to grow and go faster.", 10, 240);
		c.drawString("Never run into yourself or the edge,", 10, 270);
		c.drawString("or you'll die.", 10, 300);

		pauseProgram();
	}

	public void mainMenu() {
		title();

		c.setFont(font.deriveFont(50f));
		int x = 210;
		c.drawString("1) Play", 20, x);
		c.drawString("2) Instructions", 20, x + 50);
		c.drawString("3) Leaderboard", 20, x + 100);
		c.drawString("4) Quit", 20, x + 150);

		option = c.getChar();
	}

	public void splashScreen() {
		c.clear();
		c.setFont(new Font("Comic Sans MS", 1, 100));
		c.setColor(Color.decode("#8BC34A"));
		for (int x = -350; x < 0; x++) {
			c.clear();
			c.drawString("SCHWARTZ", 35, 210 + x);
			c.drawString("STUDIOS", 75, 310 + x);
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

	public void snake() {

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
		for (int x = 0; x < 10; x++)
			c.drawString(players[x] + ": " + scores[x], 10, 150 + x * 30);

		pauseProgram();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ISP i = new ISP();
		i.splashScreen();
		while (true) {
			i.mainMenu();
			if (i.option == '1')
				i.snake();
			else if (i.option == '2')
				i.instructions();
			else if (i.option == '3')
				i.leaderboard();
			else if (i.option == '4')
				break;
			else {
				JOptionPane.showMessageDialog(null, "That's not a valid input! Press OK to continue.",
						"You've Made A Horrible Life Choice", JOptionPane.ERROR_MESSAGE);
			}

		}
		i.goodBye();
	}
}
