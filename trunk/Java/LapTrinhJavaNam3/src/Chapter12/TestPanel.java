package Chapter12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.nio.ByteOrder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestPanel extends JFrame {

	/**
	 * @param args
	 */
	public TestPanel(){
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,3));
		
		for (int i = 1; i < 10; i++) {
			p1.add(new JButton("" + i));
		}
		p1.add(new JButton("0"));
		p1.add(new JButton("Start"));
		p1.add(new JButton("Stop"));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(new JTextField("Time to be displayed here"), BorderLayout.NORTH);
		p2.add(p1,BorderLayout.CENTER);
		
		add(p2,BorderLayout.EAST);
		add(new JButton("Food to be displayed here"),BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPanel myFrame = new TestPanel();
		myFrame.pack();
		myFrame.setTitle("Panel");
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
