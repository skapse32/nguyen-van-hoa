package com.nvh.readwrite.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class StringData {

	public static String Read(Socket connection){
		try {
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String s = br.readLine();
			return s;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static boolean write(Socket connection, String text){
		try {
			OutputStream os = connection.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println(text);
			pw.flush();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
