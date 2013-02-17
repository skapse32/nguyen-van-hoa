package Chapter14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class HandleEvent extends JFrame{

	/**
	 * @param args
	 */
	
	public class Listener_OK implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("OK Button clicked");
		}
		
	}
	
	public class Listener_CANCEL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("CANCEL Button clicked");
		}
		
	}
	
	public HandleEvent(){
		JPanel myPanel = new JPanel();
		JButton btn_Ok = new JButton("OK");
		JButton btn_Cancle = new JButton("Cancel");
		myPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		myPanel.add(btn_Ok);
		myPanel.add(btn_Cancle);
		myPanel.setBorder(new TitledBorder("Button Click"));
		
		
		//setListener
		Listener_OK listener_OK = new Listener_OK();
		Listener_CANCEL listener_CANCEL = new Listener_CANCEL();
		btn_Ok.addActionListener(listener_OK);
		btn_Cancle.addActionListener(listener_CANCEL);
		
		add(myPanel);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandleEvent myFrame = new HandleEvent();
		myFrame.setTitle("Handle Event");
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
