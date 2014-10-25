import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JPanel implements ComponentListener, ItemListener{

	static JFrame frame;
	JTextArea display;
	JLabel label;
	String newline = "\n";
	
	public WordCounter(){
		super(new BorderLayout());
		
		display = new JTextArea();
		display.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(display);
		scrollPane.setPreferredSize(new Dimension(350,200));
		
		JPanel panel = new JPanel(new BorderLayout());
		label = new JLabel ("this is a label", JLabel.CENTER);
		label.addComponentListener(this);
		panel.add(label, BorderLayout.CENTER);
		
		JCheckBox checkbox = new JCheckBox("Label Visible", true);
		checkbox.addItemListener(this);
		checkbox.addComponentListener(this);
		panel.add(checkbox, BorderLayout.PAGE_END);
		panel.addComponentListener(this);
		
		add(scrollPane, BorderLayout.CENTER);
		add(panel, BorderLayout.PAGE_END);
		frame.addComponentListener(this);
		
	}
	
	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			label.setVisible(true);
			
			label.revalidate();
			label.repaint();
			
		}else{
			label.setVisible(false);
		}
	}
	
	protected void displayMessage(String message){
		display.append(message + newline);
		display.setCaretPosition(display.getDocument().getLength());
	}
	
	public void componentHidden(ComponentEvent e){
		displayMessage(e.getComponent().getClass().getName() + "----hidden");
		
	}
	public void componentMoved(ComponentEvent e){
		displayMessage(e.getComponent().getClass().getName() + "==== Moved");
		
	}
	
	public void componentResized(ComponentEvent e){
		displayMessage(e.getComponent().getClass().getName() + " ----Resized");
	}
	
	public void componentShown(ComponentEvent e){
		displayMessage(e.getComponent().getClass().getName()+ " ---shown");
		
	}
	
	public static void createAndShowGUI(){
		frame = new JFrame("ComponentEventDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComponent newContentPane = new WordCounter();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String [] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowGUI();
			}
		});
	}
}
