package Chapter12;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame {
	public static void main(String[] args){
		JFrame myFrame = new JFrame("Hello Java SE");
		
		//Add a button
		JButton btn = new JButton("Click me!");
		myFrame.add(btn);
		
		myFrame.setSize(400, 300);
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}
}
