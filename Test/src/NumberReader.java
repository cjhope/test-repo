import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class NumberReader extends JFrame{

	static JTextArea jta;
	static JScrollPane jsp;
	static ComponentListener cel;
	
	public static void main (String [] args){
		
		NumberReader nr = new NumberReader();
		
		JTextField entry = new JTextField("Enter a string");
		entry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = entry.getText();
				jta.append("\n" + s);
				entry.setText("");
			}
		});
		
		JPanel contentPane = new JPanel(new GridLayout(2,0));
		
		JPanel textArea = new JPanel();
		textArea.setLayout(new FlowLayout());
		textArea.addComponentListener(cel);
		textArea.add(entry);
		JButton b1 = new JButton("Enter text");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = entry.getText();
				jta.setText(s);
				entry.setText("");
			}
		});
		
		JPanel display = new JPanel(new GridLayout(2,0));
		JPanel content = new JPanel();
		
		
		
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		display.add(b1);
		display.add(jsp);
		
		contentPane.setPreferredSize(new Dimension(400,400));
		contentPane.add(textArea);
		contentPane.add(display);
		nr.add(contentPane);
		nr.pack();
		nr.setVisible(true);
		
		entry.setColumns(nr.getWidth());
		nr.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	public void componentHidden(ComponentEvent e){
		
	}
	
	public void componentMoved(ComponentEvent e){
		
	}
	
	public void componentResized(ComponentEvent e){
		
	}
	
	public void componentShown(ComponentEvent e){
		
	}
	
}
