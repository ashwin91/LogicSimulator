import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class closeTab extends AbstractAction {

	DigitalCircuitSimulator gui;
	closeTab(DigitalCircuitSimulator obj)
	{ 
		super("Close");
		gui=obj;
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		gui.desktop.removeTabAt(gui.desktop.getSelectedIndex());//Tab("Window "+gui.tabcount++, new JScrollPane(new Canvas()));
		
		//gui.validate();
	}
}
