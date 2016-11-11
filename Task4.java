/*Kyle Schwartz
 *Mrs. Krasteva
 *28/09/2016
 *Template
 */
import hsa.Console;

public class Task4
{
    static Console c;

    public Task4 ()
    {
	c = new Console ();
    } // Class constructor
    
    public void box ()
    {
    	c.drawLine(220, 200, 420, 200);
    	c.drawLine(420, 200, 420, 300);
    	c.drawLine(420, 300, 220, 300);
    	c.drawLine(220, 300, 220, 200);
    	c.drawOval(295, 225, 50, 50);
    }

    public static void main (String[] args)
    {
	Task4 ts = new Task4 ();
	ts.box ();
    }
}
