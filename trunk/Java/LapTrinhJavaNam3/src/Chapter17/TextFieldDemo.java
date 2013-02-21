package Chapter17;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TextFieldDemo extends RadioButtonDemo {

	private JTextField txt_input;
	private JLabel lbl_input;

	/**
	 * @param args
	 */
	public TextFieldDemo() {
		super();
		// TODO Auto-generated constructor stub
		JPanel panel_txt = new JPanel(new BorderLayout(5, 0));
		txt_input = new JTextField(10);
		lbl_input = new JLabel("Enter String Here : ");
		
		panel_txt.setBorder(new TitledBorder(""));
		panel_txt.add(lbl_input,BorderLayout.WEST);
		panel_txt.add(txt_input,BorderLayout.CENTER);
		
		add(panel_txt,BorderLayout.NORTH);
		txt_input.setHorizontalAlignment(JTextField.RIGHT);
		txt_input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				myText.setLabel(txt_input.getText());
				txt_input.requestFocusInWindow();
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextFieldDemo mFrame = new TextFieldDemo();
		mFrame.setTitle("DEMO RADIO BUTTON");
		mFrame.setSize(500, 200);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setLocationRelativeTo(null);
		mFrame.setVisible(true);
	}

	

}
