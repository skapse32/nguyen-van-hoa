package Chapter9;

import java.io.File;
import java.util.Date;

public class TestFileClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File myFile = new File("image/text.txt");
		System.out.println("Does it exits? " + myFile.exists());
		System.out.println("The File has " + myFile.length() + " Bytes");
		System.out.println("Can it write ? " + myFile.canWrite());
		System.out.println("Can it read ? " + myFile.canRead());
		System.out.println("Is it a File ?" + myFile.isFile());
		System.out.println("Is it a Directory ? " + myFile.isDirectory());
		System.out.println("Is it a Absolute ?" + myFile.isAbsolute());
		System.out.println("Is it a Hidden ?" + myFile.isHidden());
		
		System.out.println("The Absolute path of it is : " + myFile.getAbsolutePath());
		System.out.println("Last Modified : " + new Date(myFile.lastModified()));
	}

}
