package Chapter12;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShowFlowLayout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public ShowFlowLayout(){
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		//add control
		add(new JLabel("Input :"));
		add(new JTextField(8));
		add(new JButton("Ok"));
		add(new JTextField(8));

		add(new JButton("Ok"));

		add(new JTextField(8));
		//pack();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowFlowLayout myFrame = new ShowFlowLayout();
		myFrame.setTitle("Flow Layout");
		myFrame.setSize(400, 300);
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
