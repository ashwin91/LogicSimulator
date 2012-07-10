import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.IOException;

import javax.swing.JPanel;

import ObjectLibrary.Gate;


class myDropTargetAdapter extends DropTargetAdapter {

	JPanel dropPanel;
	Point dropPoint;
	public void drop(DropTargetDropEvent dtde) {
		// TODO Auto-generated method stub
		dtde.acceptDrop(dtde.getDropAction());
		dropPoint= dtde.getLocation();
		dropPanel=(JPanel) dtde.getDropTargetContext().getComponent();
		Transferable tr = dtde.getTransferable( );
		DataFlavor[] flavours=tr.getTransferDataFlavors( );
		try {
				 Gate g=(Gate) tr.getTransferData(flavours[0]);
				 g.drawImage(dropPanel, dropPoint);
				
			}catch (UnsupportedFlavorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dtde.rejectDrop( );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dtde.rejectDrop( );
			}
			dtde.dropComplete(true);
		}

	}


