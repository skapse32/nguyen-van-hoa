package Chapter17;

import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestButtonIcon extends JFrame{

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestButtonIcon mFrame = new TestButtonIcon();
		mFrame.setTitle("TEST BUTTON ICON");
		mFrame.pack();
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setLocationRelativeTo(null);
		mFrame.setVisible(true);
	}

	public TestButtonIcon(){
		// TODO Auto-generated constructor stub
		ImageIcon carIcon = new ImageIcon("image/Car-green.png");
		ImageIcon busIcon = new ImageIcon("image/Bus-green.png");
		ImageIcon phoneIcon = new ImageIcon("image/Phone-green.png");
		JButton myButton = new JButton("Car Icon",carIcon);
		myButton.setPressedIcon(busIcon);
		myButton.setRolloverIcon(phoneIcon);
		this.add(myButton);
	}

}
