package decisions;

/*Kyle Schwartz & Lev Kropp
 *Mrs. Krasteva
 *01/11/2016
 *Decisions Problem 1
 */

import hsa.Console;


public class Problem1 {
	
	
	Console c;
	
	public Problem1(){
		c = new Console("VOWELS");
	}
	
	public static void main(String[] args) {
		Problem1 p = new Problem1();
		p.display();
	}
	
	public void display() {
		intro();
		
		title();
		String sentence = c.readLine();

		if (moreVowels(sentence)) {
			c.print("There are more vowels than consonants!");
		} else {
			c.print("There are more consonants than vowels!");
		}
		
		
		outro();
		
	}
	
	private boolean moreVowels(String sentence) {
		int vowels = 0;
		int cons = 0;
		
		for (int i = 0; i < sentence.length(); i++) {
			
			if (sentence.charAt(i) == 'a' ||sentence.charAt(i) == 'e' ||sentence.charAt(i) == 'i' ||
				sentence.charAt(i) == 'o' || sentence.charAt(i) == 'u') {
				vowels++;
				
			} else if (sentence.charAt(i) != ' ') {
				cons++;
			}
		}
		
		if (vowels > cons) {
			return true;
		} else {
			return false;
		}
	}
	
	private void outro() {
		c.println();
		c.print("Thanks for using the program!");
	}
	
	private void title() {
		c.setCursor(1, 1);
		c.print("Problem 1 - More Vowels");
		
		c.setCursor(1, 56);
		c.print("Kyle Schwartz & Lev Kropp");
	}
	
	private void intro() {
		title();
		c.setCursor(12, 38);
		c.println("VOWELS");
		c.setCursor(13, 15);
		c.print("This program will take a sentence as input and return");
		c.setCursor(14, 18);
		c.print("true if there are more vowels than consonants.");
		c.getChar();
		c.clear();
	}
	
	
}
