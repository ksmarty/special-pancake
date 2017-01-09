package isp;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import hsa.Console;

/*-
 * Kyle Schwartz
 * Snake!
 * Mrs. Krasteva
 * January 9, 2017
 * This program allows you to play the classic game snake. The user has many options that 
 * most games have including instructions, settings, a leaderboard, and the game itself.
 */
/*-****************************************************************************************
 * Variables 
 * Name				Type				Description
 * ---------------------------------------------------------------------------------------
 * c				Console				Stores an instance of the ISP.java console
 * volume			FloatControl		Stores the current music volume
 * song1			File				Stores the song1.wav file
 * song2			File				Stores the song2.wav file
 * song3			File				Stores the song3.wav file
 * audioInputStream	AudioInputStream	Stores the Audio Input Stream
 * play				Clip				Contains the current clip being played
 * song				File				Stores the current song being played
 *****************************************************************************************/

public class Music extends Thread {
	Console c;
	static FloatControl volume;
	static File song1 = new File("song1.wav");
	static File song2 = new File("song2.wav");
	static File song3 = new File("song3.wav");
	static AudioInputStream audioInputStream;
	static Clip play = null;
	static File song = song1;

	public Music(Console c) {
		this.c = c;
	}

	public void music() {
		while (true) {
			try {
				audioInputStream = AudioSystem.getAudioInputStream(song);
				play = AudioSystem.getClip();
				play.open(audioInputStream);
				volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);
				volume.setValue(-15f);
				play.start();
				do {
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
					}
				} while (play.isRunning());
				play.drain();
			} catch (UnsupportedAudioFileException e) {
			} catch (IOException e) {
			} catch (LineUnavailableException e) {
			} finally {
				try {
					play.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public void run() {
		music();
	}
}
