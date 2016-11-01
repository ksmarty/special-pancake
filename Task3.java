/*Kyle Schwartz
 *Mrs. Krasteva
 *28/09/2016
 *Template
 */
import hsa.Console;

public class Task3
{
    static Console c;

    public Task3 ()
    {
	c = new Console ();
    } // Class constructor
    
    public void flag ()
    {
    	c.drawRect(0, 0, 200, 100);
    	c.drawLine(0, 10, 200, 10);
    	c.drawLine(20, 0, 20, 100);
    }

    public static void main (String[] args)
    {
	Task3 ts = new Task3 ();
	ts.flag ();
    }
}
