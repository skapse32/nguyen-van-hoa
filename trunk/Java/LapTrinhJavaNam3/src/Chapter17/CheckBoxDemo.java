package Chapter17;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class CheckBoxDemo extends ButtonDemo {

	/**
	 * @param args
	 */
	private JCheckBox cbx_italic;
	private JCheckBox cbx_bold;
	private JCheckBox cbx_underline;
	
	public void setNewFont() {
		// TODO Auto-generated method stub
		int fontStyle = Font.PLAIN;
		fontStyle+=(cbx_italic.isSelected()?Font.ITALIC : Font.PLAIN);
		fontStyle+=(cbx_bold.isSelected()?Font.BOLD : Font.PLAIN);
		fontStyle+=(cbx_underline.isSelected()?Font.BOLD : Font.PLAIN);
		Font myFont = myText.getFont();
		myText.setFont(new Font(myFont.getName(), fontStyle, myFont.getSize()));
	}
	
	public CheckBoxDemo() {
		super();
		// TODO Auto-generated constructor stub

		JPanel myPanel = new JPanel();
		myPanel.setLayout(new GridLayout(3, 1));
		cbx_bold = new JCheckBox("Bold");
		cbx_italic = new JCheckBox("Italic");
		cbx_underline = new JCheckBox("UnderLine");
		
		myPanel.setBorder(new TitledBorder("CheckBox"));
		myPanel.add(cbx_bold);
		myPanel.add(cbx_italic);
		myPanel.add(cbx_underline);
		
		add(myPanel,BorderLayout.EAST);
		
		CheckboxListener myListener = new CheckboxListener();
		cbx_bold.addActionListener(myListener);
		cbx_italic.addActionListener(myListener);
		cbx_underline.addActionListener(myListener);
	}
	
	private class CheckboxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setNewFont();
		}
		
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBoxDemo mFrame = new CheckBoxDemo();
		mFrame.setTitle("DEMO CHECKBOX");
		mFrame.setSize(500, 200);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setLocationRelativeTo(null);
		mFrame.setVisible(true);
	}

	

}
