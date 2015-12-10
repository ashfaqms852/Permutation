package permutation.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import permutation.controller.PermutationController;


public class DisplayOutput extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7463838597873033361L;
	private static DisplayOutput displayOutput;
	ScrollPaneComponent scrPane;
	
	//constructor
	private DisplayOutput(){
	
	}
	
	//Panel class
	class PanelComponent extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -1043295675467597279L;

		PanelComponent(){
			
		}
		@Override
		public void paint(Graphics g){
			System.out.println("Painting");
			super.paint(g);
			Graphics2D graphics2D = (Graphics2D) g;
			PermutationController.drawPermutation(graphics2D);
		}
	}
	
	//scroll panel class
	class ScrollPaneComponent extends JScrollPane{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 3499378255720826410L;

		public ScrollPaneComponent(JComponent component,int v, int h) {
			super(component,v, h);
		}
		
	}
	
	//singleton
    public static DisplayOutput getInstance(){
		if(displayOutput==null){
			displayOutput = new DisplayOutput();
		}
		return displayOutput;
	}
	
    //the initialization of the jFrame goes here
	public void init(){
		displayOutput = getInstance();
		displayOutput.setSize(1000, 800);
		displayOutput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayOutput.setTitle("Permutation Output");
		displayOutput.setLocationRelativeTo(null);
		int v=ScrollPaneConstants. VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants. HORIZONTAL_SCROLLBAR_ALWAYS;
		PanelComponent pc = new PanelComponent();
		pc.setLayout( new GridLayout(8000, 8000, 30, 30));
		scrPane = new ScrollPaneComponent(pc,v,h);
		scrPane.getHorizontalScrollBar().setUnitIncrement(16);
		scrPane.getVerticalScrollBar().setUnitIncrement(16);
		displayOutput.add(scrPane,BorderLayout.CENTER);
		displayOutput.setVisible(true);
	}
	
	//will do refresh after doing the permutation
	public void refresh(){
		displayOutput.repaint();
	}

	/*public static void main(String[] args) {
		displayOutput = getInstance();
		displayOutput.init();
	}*/
}
