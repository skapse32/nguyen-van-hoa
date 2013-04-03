package Tuan6;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LookAndFeel extends JFrame{
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			new LookAndFeel();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public LookAndFeel() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(1,2));
		add(new JTextField(8));
		add(new JButton());
		setSize(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
