package ObjectLibrary;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPopupMenu;


class myMouseListener extends MouseAdapter {

	JButton b;;
	public myMouseListener(JButton g) {
		b=g;
	}
	public void mouseClicked(MouseEvent me)
	{
		if(me.isMetaDown())
		{
			JPopupMenu popup=new JPopupMenu();
			popup.add(new ConfigureGate());
			popup.show(b,me.getPoint().x,me.getPoint().y);
		}
	}
}
