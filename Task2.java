/*Kyle Schwartz
 *Mrs. Krasteva
 *28/09/2016
 *Template
 */
import hsa.Console;

public class Task2
{
    static Console c;

    public Task2 ()
    {
	c = new Console ();
    } // Class constructor
    
    public void box ()
    {
    	c.drawLine(220, 200, 420, 200);
    	c.drawLine(420, 200, 420, 300);
    	c.drawLine(420, 300, 220, 300);
    	c.drawLine(220, 300, 220, 200);
    }

    public static void main (String[] args)
    {
	Task2 ts = new Task2 ();
	ts.box ();
    }
}
