
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LorentzCalc {

	static JPanel child1;
	static JPanel child2;
	static JPanel panel;
	static JButton c1Button;
	static JButton c2Button;
	static JFrame frame;
	static Dimension defDim = new Dimension(450, 450);
	static JPanel sideBar;
	static JTextArea output;
	static JPanel workingArea1;
	static JPanel workingArea2;
	static JPanel workingArea3;
	static JPanel workingArea4;
	
	static JPanel welcomeScreen;
	final double c = 299790000;
	
	
	public static void main(String [] args){
	frame = new JFrame();
	String[] problems = { 
			"Calculate x\'", 
			"Calculate gamma", 
			"Calculate t\'" 
			};
	
	JComboBox problemList = new JComboBox(problems);
	problemList.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JComboBox cb = (JComboBox)e.getSource();
			String selection = (String)cb.getSelectedItem();
			int index = (int)cb.getSelectedIndex();
			//output.append(selection + "\n");
			
			switch(index){
			case 0:
				child1.removeAll();
				sideBar.add(problemList);
				child1.add(sideBar, BorderLayout.WEST);
				child1.add(workingArea4);
				frame.pack();
				frame.repaint();
				break;
			case 1:
				child1.removeAll();
				sideBar.add(problemList);
				child1.add(sideBar, BorderLayout.WEST);
				child1.add(workingArea2);
				frame.pack();
				frame.repaint();
				break;
			case 2:
				child1.removeAll();
				sideBar.add(problemList);
				child1.add(sideBar, BorderLayout.WEST);
				child1.add(workingArea3);
				frame.pack();
				frame.repaint();
				break;
			
			}
		}
	});
	
	//Side Bar definition
	
	sideBar = new JPanel(new FlowLayout());
	sideBar.setPreferredSize(new Dimension(150, 450));
	sideBar.add(problemList);
	
	
	
	//Parent panel
	panel = new JPanel(new GridBagLayout());
	
	
	//Child panel 1
	child1 = new JPanel(new BorderLayout());
	child1.setPreferredSize(defDim);
	
	
	child1.add(problemList, BorderLayout.WEST);
	
	workingArea1 = new JPanel(new BorderLayout());
	workingArea1.setPreferredSize(new Dimension(300, 450));
	//workingArea1.setBackground(Color.white);
	workingArea1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	workingArea1.setBackground(Color.red);
	
	
	workingArea2 = new JPanel(new BorderLayout());
	workingArea2.setPreferredSize(new Dimension(300, 450));
	//workingArea2.setBackground(Color.white);
	workingArea2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	workingArea2.setBackground(Color.green);
	
	
	workingArea3 = new JPanel(new BorderLayout());
	workingArea3.setPreferredSize(new Dimension(300, 450));
	//workingArea3.setBackground(Color.white);
	workingArea3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	workingArea3.setBackground(Color.blue);
	
	
	workingArea4 = new JPanel(new BorderLayout());
	workingArea4.setPreferredSize(new Dimension(300, 450));
	workingArea4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	workingArea4.setBackground(Color.red);
	
	output = new JTextArea();
	workingArea1.add(output);
	child1.add(workingArea1);
	
	
	
	
	
	//Child panel 2
	child2 = new JPanel(new GridBagLayout());
	child2.setPreferredSize(defDim);
	c2Button = new JButton("Now Press Me!");
	c2Button.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			frame.remove(child2);
			frame.add(child1);
			frame.pack();
			frame.repaint();
		}
	});
	child2.add(c2Button);
	
	
	
	//Welcome Screen
	welcomeScreen = new JPanel(new FlowLayout());
	welcomeScreen.setPreferredSize(defDim);
	JPanel welcomeButtonArea = new JPanel(new GridBagLayout());
	welcomeButtonArea.setPreferredSize(new Dimension(450, 250));
	
	JTextArea welcomeText = new JTextArea();
	welcomeText.setPreferredSize(new Dimension(450, 200));
	welcomeText.setEditable(false);
	Font font = new Font("Verdana", Font.BOLD, 20);
	welcomeText.setText("Lorentz Transform Position \nCalculator v0.1");
	welcomeText.setFont(font);
	welcomeText.setBackground(Color.BLACK);
	welcomeText.setForeground(Color.white);
	welcomeText.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
	welcomeText.setAlignmentX(15);
	welcomeText.setAlignmentY(20);
	JButton toChild1 = new JButton ("Click to begin");
	toChild1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			frame.remove(welcomeScreen);
			frame.add(child1);
			frame.pack();
			frame.repaint();
		}
	});
	
	welcomeScreen.add(welcomeText);
	welcomeButtonArea.add(toChild1);
	welcomeScreen.add(welcomeButtonArea);
	
	//End Welcome Screen code
	
	frame.add(welcomeScreen);
	frame.pack();
	frame.setVisible(true);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public double xPrime(double xInit, double vFrame, double time){
		
		return gamma(vFrame)*(xInit - vFrame*time);
		
	}
	public double gamma(double vFrame){
		double ans = 0;
		ans = 1 / (Math.sqrt(1 - Math.pow(vFrame/c, 2)));
		return ans;
	}
}
