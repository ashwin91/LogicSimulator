
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceAdapter;
import java.awt.dnd.InvalidDnDOperationException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ObjectLibrary.Gate;

class toolbutton extends JButton {

	private static ImageIcon img;
	Constructor trnsf;
	
	//String label;
	public toolbutton(Class cl) {
		super(img=new ImageIcon("images/"+cl.getSimpleName().toLowerCase()+".gif"));
		
		try {
			trnsf=cl.getDeclaredConstructor();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(30,30);
		setToolTipText(cl.getSimpleName()+" Gate");
		DragSource ds=DragSource.getDefaultDragSource();
		//System.out.println(DragSource.isDragImageSupported());
		ds.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY, new dragListener());
	}	

class dragListener implements DragGestureListener {
	
	//methods for DragGestureListener Interface
	public void dragGestureRecognized(DragGestureEvent dgev) {
		
		try {
			dgev.startDrag(DragSource.DefaultCopyDrop,img.getImage(),new Point(img.getIconWidth()/2, img.getIconHeight()/2),(Transferable) trnsf.newInstance(),new DragSourceAdapter(){});
		} catch (InvalidDnDOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.print("recongnized");
	}
}

}

