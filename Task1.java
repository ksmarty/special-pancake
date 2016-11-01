/*Kyle Schwartz
 *Mrs. Krasteva
 *28/09/2016
 *Template
 */
import java.awt.Color;
import java.awt.Font;

import hsa.Console;

public class Task1
{
    static Console c;

    public Task1 ()
    {
	c = new Console ();
    } // Class constructor
    
    public void title ()
    {
    	c.setFont(new Font ("Arial",1,20));
    	c.setColor(Color.black);
    	c.drawString("ICS3U", 300, 20);
    }
    
    public void logo ()
    {
    	c.draw3DRect(50, 300, 80, 80, true);
    	c.drawStar(600, 70, 30, 20);
    	c.drawMapleLeaf(320, 40, 100, 150);
    }

    public static void main (String[] args)
    {
	Task1 ts = new Task1 ();
	ts.title ();
	ts.logo ();
    }
}
