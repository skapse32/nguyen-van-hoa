package Chapter9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteData {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File myFile = new File("data.txt");
		if(myFile.exists()){
			System.out.println("File exist!!");
			System.exit(0);
		}
		
		PrintWriter output = new PrintWriter(myFile);
		
		output.println("Nguyễn Văn Hòa");
		output.println("SPKT");
		
		output.close();
	}

}
