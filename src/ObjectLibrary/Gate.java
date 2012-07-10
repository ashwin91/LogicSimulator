package ObjectLibrary;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class Gate implements Transferable{

	//private String name;
	String image;
	JButton b;
	ImageIcon img;
	
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		
		return this;
	}

	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor df[]=new DataFlavor[1];
		df[0]=new DataFlavor(getClass(), getClass().getSimpleName());
		return df;
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
		
		return false;
	}
	
	public abstract void drawImage(JPanel c,Point dropPoint);
	
}
