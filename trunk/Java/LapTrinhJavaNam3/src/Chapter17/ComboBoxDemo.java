package Chapter17;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxDemo extends JFrame {

	private JComboBox cbx_input;
	private String title[] = {"Android","WindowPhone","Symbian","Ubuntu","IOS"
			,"Bada"};
	
	private ImageIcon[] icon = {
			new ImageIcon("image/Clock-green.png"),
			new ImageIcon("image/Calender-green.png"),
			new ImageIcon("image/Battlenet-green.png"),
			new ImageIcon("image/Android-green.png"),
			new ImageIcon("image/Camera-green.png"),
			new ImageIcon("image/Google-Earth.png")
	};
	
	private String[] flagDescription = new String[6];
	
	public ComboBoxDemo()  {
		super();
		flagDescription[0] = "The Maple Leaf flag \n\n"
				+ "The Canadian National Flag was adopted by the Canadian "
				+ "Parliament on October 22, 1964 and was proclaimed into law "
				+ "by Her Majesty Queen Elizabeth II (the Queen of Canada) on "
				+ "February 15, 1965. The Canadian Flag (colloquially known "
				+ "as The Maple Leaf Flag) is a red flag of the proportions "
				+ "two by length and one by width, containing in its center a "
				+ "white square, with a single red stylized eleven-point "
				+ "maple leaf centered in the white square.";
		flagDescription[1] = "Description for WindowsPhone ....";
		flagDescription[2] = "Description for Symbian ....";
		flagDescription[3] = "Description for Ubuntu ....";
		flagDescription[4] = "Description for IOS ....";
		flagDescription[5] = "Description for Bada ....";
		
		cbx_input = new JComboBox(title);
		
		final DescriptionPanel mDescriptionPanel = new DescriptionPanel();
		
		setLayout(new BorderLayout(5, 5));
		add(cbx_input,BorderLayout.NORTH);
		add(mDescriptionPanel,BorderLayout.CENTER);
		
		cbx_input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mDescriptionPanel.setImageIcon(icon[cbx_input.getSelectedIndex()]);
				mDescriptionPanel.setDescription(flagDescription[cbx_input.getSelectedIndex()]);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComboBoxDemo frame = new ComboBoxDemo();

		frame.pack();
		frame.setLocationRelativeTo(null);// Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ComboBox Demo");
		frame.setVisible(true);
	}

}
