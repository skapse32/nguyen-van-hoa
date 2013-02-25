package Chapter18;


import javax.swing.ImageIcon;
import javax.swing.JApplet;

import Chapter17.DescriptionPanel;

public class DisplayLabel extends JApplet {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		DescriptionPanel myDescription = new DescriptionPanel();
		myDescription.setTitle("Canada");
		String description = "The Maple Leaf flag \n\n"
				+ "The Canadian National Flag was adopted by the Canadian "
				+ "Parliament on October 22, 1964 and was proclaimed into law "
				+ "by Her Majesty Queen Elizabeth II (the Queen of Canada) on "
				+ "February 15, 1965. The Canadian Flag (colloquially known "
				+ "as The Maple Leaf Flag) is a red flag of the proportions "
				+ "two by length and one by width, containing in its center a "
				+ "white square, with a single red stylized eleven-point "
				+ "maple leaf centered in the white square.";
		myDescription.setDescription(description);

		add(myDescription);
	}
}
