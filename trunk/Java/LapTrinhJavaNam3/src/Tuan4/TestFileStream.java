package Tuan4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		
		try(FileOutputStream fs = new FileOutputStream("temp.dat")) {
			byte[] b = new byte[1024];
			int c = System.in.read(b);
			fs.write(b,0,c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileInputStream open = new FileInputStream("temp.dat")) {
			byte[] buffer = new byte[1024];
			int value;
			int cnt = open.read(buffer);
			String s = new String(buffer, 0, cnt);
			System.out.println("Text output : " + s +" "+cnt);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
