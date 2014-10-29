import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Test {

	public static void main (String [] args){
		
		
		
		JFrame frame = new JFrame("Colored Squares");
		JPanel contentPane = new JPanel(new GridLayout(2,2));
		
		
		JPanel rightPanelTop = new JPanel();
		rightPanelTop.setBackground(Color.BLACK);
		JButton b1 = new JButton("Right Top");
		rightPanelTop.add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rightPanelTop.setBackground(randomColor());
			}
		});
		
		JPanel rightPanelBottom = new JPanel();
		rightPanelBottom.setBackground(Color.blue);
		JButton b2 = new JButton ("Right Bottom");
		rightPanelBottom.add(b2);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rightPanelBottom.setBackground(randomColor());
			}
		});
		
		
		JPanel leftPanelTop = new JPanel();
		leftPanelTop.setBackground(Color.red);
		JButton b3 = new JButton("Left Top");
		leftPanelTop.add(b3);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				leftPanelTop.setBackground(randomColor());
			}
		});
		
		JPanel leftPanelBottom = new JPanel();
		leftPanelBottom.setBackground(Color.GREEN);
		JButton b4 = new JButton("Left Bottom");
		leftPanelBottom.add(b4);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				leftPanelBottom.setBackground(randomColor());
			}
		});
		
		contentPane.setPreferredSize(new Dimension(400,400));
		
		contentPane.add(leftPanelTop);
		contentPane.add(rightPanelTop);
		contentPane.add(leftPanelBottom);
		contentPane.add(rightPanelBottom);
		
		frame.add(contentPane);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static Color randomColor(){
		Color myColor;
		Random r = new Random();
		int randomNumber = r.nextInt((6)) + 1;
		switch(randomNumber){
		case 1:
			myColor = Color.RED;
			break;
		case 2:
			myColor = Color.BLUE;
			break;
		case 3:
			myColor = Color.GREEN;
			break;
		case 4:
			myColor = Color.cyan;
			break;
		case 5:
			myColor = Color.DARK_GRAY;
			break;
		case 6:
			myColor = Color.YELLOW;
			break;
		default:
			myColor = Color.BLACK;
			break;
			
		
		}
		
		return myColor;
	}
	
	
	
}
