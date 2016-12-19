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

public class Music implements Runnable {
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

	public void run() {
		while (true) {
			try {
				audioInputStream = AudioSystem.getAudioInputStream(song);
				play = AudioSystem.getClip();
				play.open(audioInputStream);
				volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);
				volume.setValue(0.0f);
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
}
