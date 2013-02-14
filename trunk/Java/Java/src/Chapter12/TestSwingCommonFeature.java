package Chapter12;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TestSwingCommonFeature extends JFrame {

	/**
	 * @param args
	 */
	public TestSwingCommonFeature() {
		setLayout(new GridLayout(2,1));
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));

		// Controls
		JButton btn_left = new JButton("Left");
		JButton btn_center = new JButton("Center");
		JButton btn_right = new JButton("Right");

		btn_left.setBackground(Color.WHITE);
		btn_center.setBackground(Color.GREEN);
		btn_right.setToolTipText("This is an Button");

		p1.add(btn_left);
		p1.add(btn_center);
		p1.add(btn_right);
		p1.setBorder(new TitledBorder("Three Buttons"));

		// Create Font and Border
		Font myFont = new Font("TimesRoman", Font.BOLD, 20);
		Border myBoder = new LineBorder(Color.BLACK, 2);

		JPanel p2 = new JPanel(new GridLayout(1, 2, 5, 5));
		JLabel lbl_red = new JLabel("RED");
		JLabel lbl_orange = new JLabel("Orange");
		lbl_red.setForeground(Color.RED);
		lbl_red.setBorder(myBoder);
		lbl_red.setFont(myFont);
		lbl_orange.setForeground(Color.ORANGE);
		lbl_orange.setBorder(myBoder);
		lbl_orange.setFont(myFont);
		
		p2.setBorder(new TitledBorder("Two Labels"));
		p2.add(lbl_red);
		p2.add(lbl_orange);
		
		add(p1);
		add(p2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSwingCommonFeature myFrame = new TestSwingCommonFeature();
		myFrame.pack();
		myFrame.setTitle("Test Swing Common Feature");
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
