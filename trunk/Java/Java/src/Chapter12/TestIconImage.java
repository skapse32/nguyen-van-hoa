/**
 * 
 */
package Chapter12;

import java.awt.FlowLayout;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author VANHOA
 *
 */
public class TestIconImage extends JFrame {

	/**
	 * @param args
	 */
	private ImageIcon icon;
	
	public TestIconImage(){
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		icon = new ImageIcon("image/logo_1.png");
		add(new JLabel(icon));
		add(new JButton(icon));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestIconImage myFrame = new TestIconImage();
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
