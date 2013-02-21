package Chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class RadioButtonDemo extends CheckBoxDemo {

	private JRadioButton rdb_red;
	private JRadioButton rdb_green;
	private JRadioButton rdb_blue;

	/**
	 * @param args
	 */
	
	public RadioButtonDemo() {
		super();
		// TODO Auto-generated constructor stub
		JPanel rd_panel = new JPanel(new GridLayout(3,1));
		rdb_red = new JRadioButton("RED");
		rdb_green = new JRadioButton("GREEN");
		rdb_blue = new JRadioButton("BLUE");
		
		rd_panel.setBorder(new TitledBorder("RadioButton"));
		rd_panel.add(rdb_red);
		rd_panel.add(rdb_green);
		rd_panel.add(rdb_blue);
		
		ButtonGroup myGroup = new ButtonGroup();
		myGroup.add(rdb_red);
		myGroup.add(rdb_green);
		myGroup.add(rdb_blue);
		
		add(rd_panel,BorderLayout.WEST);
		
		rdb_red.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				myText.setForeground(Color.RED);
			}
		});
		
		rdb_blue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myText.setForeground(Color.BLUE);
			}
		});
		
		rdb_green.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myText.setForeground(Color.GREEN);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadioButtonDemo mFrame = new RadioButtonDemo();
		mFrame.setTitle("DEMO RADIO BUTTON");
		mFrame.setSize(500, 200);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setLocationRelativeTo(null);
		mFrame.setVisible(true);
	}

	

}
