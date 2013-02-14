package Chapter12;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShowGridLayout extends JFrame{

	/**
	 * @param args
	 */
	
	public ShowGridLayout(){
		setLayout(new GridLayout(2, 2, 5, 5));
		
		//add controls
		add(new JLabel("User Name :"));
		add(new JTextField(8));
		add(new JLabel("Password : "));
		add(new JTextField(8));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowGridLayout myFrame = new ShowGridLayout();
		myFrame.setSize(200, 150);
		myFrame.setTitle("Grid Layout");
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
