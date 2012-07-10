package ObjectLibrary;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.ButtonUI;

public class And extends Gate 
{

	String image;
	public And()
	{
		image="images/and.gif";
	}
	public void drawImage(JPanel c,Point dropPoint)
	{
		b=new JButton(img=new ImageIcon(image));
		b.setBounds(dropPoint.x, dropPoint.y, 30, 30);
		//b.setLocation(dropPoint);
		c.add(b);
		b.addMouseListener(new myMouseListener(b));
		b.addMouseMotionListener(new myMouseMotionListener(b,c));
	}
}
