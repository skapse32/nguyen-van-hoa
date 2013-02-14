package Chapter9;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ReadFileUsingJFileChooser {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JFileChooser myChooser = new JFileChooser();
		if (myChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //Ok button
			File myFile = myChooser.getSelectedFile();
			Scanner myScanner = new Scanner(myFile);
			while(myScanner.hasNext()){
				System.out.println(myScanner.nextLine());
			}
			myScanner.close();
		}else{
			JOptionPane.showMessageDialog(null, "Not File Selected", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

}
