import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyWordCounter extends JPanel{

	static JFrame frame;
	static ComponentListener cel;
	
	public MyWordCounter(){
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(450,450));
		
		
		//set up a text display area, adds it to contentPane
		JTextArea display = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(display);
		scrollPane.setPreferredSize(new Dimension(450, 300));
		contentPane.add(scrollPane, BorderLayout.NORTH);
		display.setEditable(false);
		
		
		//Adds a text field 
		JTextField textfield = new JTextField("Enter some words");
		JPanel textFieldPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textFieldPanel.setPreferredSize(new Dimension(450, 25));
		textFieldPanel.addComponentListener(cel);
		textFieldPanel.add(textfield, gbc);
		textfield.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = textfield.getText();
				
				display.append("\"" + s + "\"" + " has " + countThoseWords(s) + " words\n");
				textfield.setText("");
			}
		});
		contentPane.add(textFieldPanel, BorderLayout.SOUTH);
		
		contentPane.setBackground(Color.GRAY);
		
		//Adds the content pane to the created JPanel
		add(contentPane);
		
	}
	
	
	private static void createAndShowGUI(){
		frame = new JFrame("Word Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent contentPane = new MyWordCounter();
		contentPane.setOpaque(true);
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main (String [] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowGUI();
			}
		});
	}
	
	public static int countThoseWords(String s){
		int count = 0;
		char prev = 32;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 32 && prev != 32)
				count++;
			prev = s.charAt(i);
		}
		if(prev != 32)
			count++;
		
		return count;
	}
	
}
