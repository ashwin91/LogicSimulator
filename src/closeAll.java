import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


class closeAll extends AbstractAction {

	private DigitalCircuitSimulator gui;
	closeAll(DigitalCircuitSimulator obj)
	{
		super("Close All");
		gui=obj;
	}
	public void actionPerformed(ActionEvent ae)
	{
		gui.desktop.removeAll();
	}
}
