import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import ObjectLibrary.And;


public class DigitalCircuitSimulator extends JFrame {

	private JPanel contentPane;
	JPanel dropPanel;
	private JSplitPane splitPaneH,splitPaneV;
	private JMenuBar bar;
	private JMenu file,edit,view,run;
	JTabbedPane desktop;
	private JInternalFrame consoleFrame,desktopP;
	private JTextArea console;
	private JInternalFrame mainPane,PropertyWindow;
	private JToolBar toolbar;
	int tabcount=2;
	boolean flag=false;
	private JSplitPane splitPaneP;
	
	public DigitalCircuitSimulator()
	{
		super("IGCAR Digital Circuit Simulator");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height-35);
		setLocation(0,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//initializing
		desktop=new JTabbedPane();
		//System.out.println(desktop.getFocusTraversalKeysEnabled()+"\n"+desktop.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
		
		toolbar=new JToolBar("Toolbar",JToolBar.VERTICAL);
		//toolbar.setSize(100, HEIGHT);
		toolbar.add(new toolbutton(And.class));	
		consoleFrame=new JInternalFrame("Console",false,true,false,false);
		consoleFrame.setSize(1250,150);
		consoleFrame.setLocation(0, 0);
		consoleFrame.setVisible(true);
		consoleFrame.add(console=new JTextArea());
		console.setEditable(false);
				
		mainPane=new JInternalFrame("",false,false,false,false);
		mainPane.setVisible(true);
		BasicInternalFrameUI ui = (BasicInternalFrameUI)mainPane.getUI();

		//setting the mainPane im-mobile
		ui.setNorthPane(null);
		/*MouseMotionListener[] actions =	(MouseMotionListener[])north.getListeners(MouseMotionListener.class);
		north.removeMouseMotionListener( actions[0] );*/
		
		//setting the consoleFrame im-mobile
		ui=(BasicInternalFrameUI)consoleFrame.getUI();
		Component north = ui.getNorthPane();
		MouseMotionListener[] actions =(MouseMotionListener[])north.getListeners(MouseMotionListener.class);
		north.removeMouseMotionListener( actions[0] );

		//setting windows Look and Feel
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/ 
		
		//add file bar
		bar = new JMenuBar( );
		setJMenuBar(bar);
		
		//add File file
		JMenuItem t;
		file = new JMenu("File");
		bar.add(file);
		t=file.add(new newTab(this));
		t.setAccelerator(KeyStroke.getKeyStroke('T',Toolkit.getDefaultToolkit( ).getMenuShortcutKeyMask( ), false));
		t.setMnemonic('N');
		
		file.add("Open");
		
		t=file.add(new closeTab(this));
		t.setAccelerator(KeyStroke.getKeyStroke('W',Toolkit.getDefaultToolkit( ).getMenuShortcutKeyMask( ), false));
		t.setMnemonic('C');
		
		t=file.add(new closeAll(this));
		t.setAccelerator(KeyStroke.getKeyStroke('W',Event.CTRL_MASK | Event.SHIFT_MASK));	
		
		//adding edit Menu
		edit=new JMenu("Edit");
		bar.add(edit);
		
		//adding view Menu
		view=new JMenu("View");
		bar.add(view);
		
		//adding run menu
		run=new JMenu("Run");
		bar.add(run);
		
		//get the content pane of the rootpane to add components to
		contentPane = (JPanel) getContentPane( );
		
		//creating a horizontal split pane with toolbar on left and internal frames on right.	
		splitPaneH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, toolbar, mainPane); 
        splitPaneH.setContinuousLayout(true); 
        splitPaneH.setOneTouchExpandable(true); 
        splitPaneH.setDividerLocation(80);
        
        contentPane.add(splitPaneH);
        
        //making the Internal Frame that contains Desktop and PropertyWindow in splitPaneP
        desktopP=new JInternalFrame("",false,false,false,false);
		desktopP.setVisible(true);
		ui=(BasicInternalFrameUI)desktopP.getUI();
		ui.setNorthPane(null);
		
		//setting up the PropertyWindow Frame
		   PropertyWindow=new JInternalFrame("Property",false,true,false,false);
			PropertyWindow.setSize(50,150);
			PropertyWindow.setLocation(0, 0);
			PropertyWindow.setVisible(true);
		
			//setting PropertyWindow immobile
			ui=(BasicInternalFrameUI)PropertyWindow.getUI();
			north = ui.getNorthPane();
			actions =(MouseMotionListener[])north.getListeners(MouseMotionListener.class);
			north.removeMouseMotionListener( actions[0] );
			
        //creating vertical split pane to add mainPane at top and console at bottom
        splitPaneV = new JSplitPane(JSplitPane.VERTICAL_SPLIT, desktopP, consoleFrame); 
        splitPaneV.setContinuousLayout(true); 
        splitPaneV.setOneTouchExpandable(true); 
        splitPaneV.setDividerLocation(500);
        
        mainPane.getContentPane().add(splitPaneV);
        
        //another horizontal split to divide property window 
        splitPaneP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, desktop, PropertyWindow); 
        splitPaneP.setContinuousLayout(true); 
        splitPaneP.setOneTouchExpandable(true); 
        splitPaneP.setDividerLocation(1000);
        
        desktopP.add(splitPaneP);
        
        //creating the first tab
        desktop.addTab("Window 1", new JScrollPane(dropPanel=new JPanel()));
        dropPanel.setLayout(null);
     		
        //making it a drop target
        new DropTarget(dropPanel,new myDropTargetAdapter());		
	}
	/*public void paintComponent(Graphics gr)
	{
		ImageIcon img=new ImageIcon(g.image);
		img.paintIcon(dropPanel, gr, dropPoint.x, dropPoint.y);
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalCircuitSimulator dcs=new DigitalCircuitSimulator();
		dcs.setVisible(true);

	}

}
