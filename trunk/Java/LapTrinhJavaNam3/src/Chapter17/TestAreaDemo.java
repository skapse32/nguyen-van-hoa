package Chapter17;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TestAreaDemo extends JFrame {

	public TestAreaDemo() {
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
		myDescription.setImageIcon(new ImageIcon("image/Dropbox-green.png"));

		add(myDescription);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestAreaDemo frame = new TestAreaDemo();

		frame.pack();
		frame.setLocationRelativeTo(null);// Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TextAreaDemo");
		frame.setVisible(true);
	}

}
