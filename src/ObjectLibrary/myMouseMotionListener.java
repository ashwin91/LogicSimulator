package ObjectLibrary;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class myMouseMotionListener implements MouseMotionListener {

	JButton b;
	JPanel c;
	myMouseMotionListener(JButton g,JPanel p) {
		b=g;
		c=p;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Point pc=c.getLocationOnScreen();
		Point pe=e.getLocationOnScreen();
		b.setLocation(pe.x-pc.x,pe.y-pc.y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
