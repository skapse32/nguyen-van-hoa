package Chapter9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File myFile = new File("data.txt");
		Scanner myScanner = new Scanner(myFile);
		while(myScanner.hasNext()){
			System.out.println(myScanner.next());
		}
		
		myScanner.close();
	}

}
