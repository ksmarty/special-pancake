/*Kyle Schwartz
 *Mrs. Krasteva
 *28/09/2016
 *For Loops 1
 */
import hsa.Console;

public class ForLoops1
{
    static Console c;
    int exp;

    public ForLoops1 ()
    {
	c = new Console ("Fun With Fives");
    } // Class constructor


    public void title ()
    {
	c.print ("", 33);
	c.println ("Fun With Fives\n");
    }


    public void Intro ()
    {
	c.println ("In this program, you may choose the ending exponent and the previous 11 exponenets will be automatically generated!\n");
    }


    public void UserInput ()
    {
	c.println ("What exponent do you choose? (12 or greater)");
	exp = c.readInt ();
	c.println ("");
    }


    public void Output ()
    {
	c.print ("", 37);
	c.println ("Table");
	for (int num = 1 ; num < 13 ; num++)
	{
	    int temp = 1;
	    int cexp = exp - 13 + num;
	    for (int i = 1 ; i <= cexp ; i++)
	    {
		temp = temp * 5;
	    }
	    c.print ("",35);
	    c.println ("5 ^ " + exp + " = " + temp);
	}
    }


    public static void main (String[] args)
    {
	ForLoops1 fl = new ForLoops1 ();
	fl.title ();
	fl.Intro ();
	fl.UserInput ();
	fl.Output ();
    }
}
