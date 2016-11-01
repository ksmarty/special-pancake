/*Kyle Schwartz
 *Mrs. Krasteva
 *05/10/2016
 *Template
 */

/*
 * Variable Name        Type    Description
 * character            char    Stores the user's input
 * c                            console The variable that is used to store the console.
 */
import hsa.Console;

public class ForLoops2
{
    static Console c;
    static char character;

    public ForLoops2 ()
    {
        c = new Console ("Make Your Own #");
    } // Class constructor


    /*
     * Writes a title at the top of the screen.
     */
    private void title ()
    {
        c.print ("", 33);
        c.println ("Make Your Own #\n");
    }


    /*
     * Gives the user a description of the program.
     */
    public void intro ()
    {
        title ();
        c.println ("In this program you will be able to create a # symbol using any character on \nthe keyboard!\n");
        getInput ();
    }


    /*
     * Prompts the user to enter a key.
     * Variable Name    Type    Description
     * character        char    Stores the user's input.
     */
    public void getInput ()
    {
        c.print ("Please press which key you would like to create a # with: ");
        character = c.readChar ();
    }


    /*
     * Variable Name    Type    Description
     * x                int     Used as a counted variable for the nested loops.
     * y                int     Used as a counted variable for the outer loops.
     */
    public void display ()
    {
        c.clear ();
        for (int y = 33 ; y >= 32 ; y--)
        {
        	for (int x = 1 ; x <= 3 ; x++)
        	{
        		spacePrint (y, 7);
        		spacePrint (5, 7, true);
        	}
        }

        for (int x = 24 ; x >= 22 ; x--)
        {
        	spacePrint (x, 38, true);
        }

        for (int y = 31 ; y >= 30 ; y--)
        {
        for (int x = 1 ; x <= 3 ; x++)
        
        	{
        		spacePrint (y, 7);
        		spacePrint (5, 7, true);
        	}
        }

        for (int x = 21 ; x >= 19 ; x--)
        {
        	spacePrint (x, 38, true);
        }

        for (int y = 29 ; y >= 28 ; y--)
        {
        for (int x = 1 ; x <= 3 ; x++)
        {
            spacePrint (y, 7);
            spacePrint (5, 7, true);
        }
        }

    }


    /*
     * Variable Name    Type    Description
     * space            int             Stores how many spaces are to be placed.
     * chars            int             Stores how many characters are to be typed.
     */
    private void spacePrint (int space, int chars)
    {
        c.print ("", space);
        for (int x = 1 ; x <= chars ; x++)
        {
            c.print (character);
        }
    }


    /*
     * Variable Name    Type    Description
     * space            int             Stores how many spaces are to be placed.
     * chars            int             Stores how many characters are to be typed.
     * newLine          boolean If true, calls spacePrint and prints a new line.
     */
    private void spacePrint (int space, int chars, boolean newLine)
    {
        spacePrint (space, chars);
        c.println ();
    }


    /*
     * The main method calls intro and display, executing the program.
     */
    public static void main (String[] args)
    {
        ForLoops2 fl = new ForLoops2 ();
        fl.intro ();
        fl.display ();
    }
}
