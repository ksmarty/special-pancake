package isp;

import java.awt.Color;

import hsa.Console;

public class Animation extends Thread {
	Console c;

	public Animation(Console c) {
		this.c = c;
	}

	public void intro() {
		for (int x = -350; x < 0; x++) {
			// Erase
			c.fillRect(0, 0, 800, 600, Color.decode("#8BC34A"));

			// Sets font size to 100
			c.setFont(ISP.font.deriveFont(100f));
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

	public void run() {
		intro();
	}
}
