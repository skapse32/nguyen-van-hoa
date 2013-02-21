package Chapter17;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DescriptionPanel extends JPanel {

	private JLabel jlbl_title;
	private JTextArea txtA_description;

	public DescriptionPanel() {
		super();
		// TODO Auto-generated constructor stub
		jlbl_title = new JLabel();
		jlbl_title.setHorizontalAlignment(JLabel.CENTER);
		jlbl_title.setHorizontalTextPosition(JLabel.CENTER);
		jlbl_title.setVerticalTextPosition(JLabel.BOTTOM);
		
		txtA_description = new JTextArea();
		txtA_description.setWrapStyleWord(true);
		txtA_description.setLineWrap(true);
		txtA_description.setEditable(false);
		
		JScrollPane mJScrollPane = new JScrollPane(txtA_description);
		
		setLayout(new BorderLayout(5, 5));
		add(mJScrollPane, BorderLayout.CENTER);
		add(jlbl_title,BorderLayout.WEST);
	}
	
	public void setTitle(String title){
		jlbl_title.setText(title);
	}
	
	public void setImageIcon(ImageIcon icon){
		jlbl_title.setIcon(icon);
	}
	
	public void setDescription(String content){
		txtA_description.setText(content);
	}
}
