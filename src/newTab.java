import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


class newTab extends AbstractAction {
	
	DigitalCircuitSimulator gui;
	private JPanel dropPanel;
	newTab(DigitalCircuitSimulator obj)
	{ 
		super("New");
		gui=obj;
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		gui.desktop.addTab("Window "+gui.tabcount++, new JScrollPane(dropPanel=new JPanel()));
		dropPanel.setLayout(null);
		new DropTarget(dropPanel,new myDropTargetAdapter());
	}

}
