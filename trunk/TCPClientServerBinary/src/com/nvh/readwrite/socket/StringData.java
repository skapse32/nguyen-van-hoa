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

	public static void Read(Socket connection){
		try {
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String s = "";
			writeToFile(br);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void write(Socket connection, String text){
		try {
			OutputStream os = connection.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			FileReader fr = new FileReader(text);
			BufferedReader br = new BufferedReader(fr);
			String s = "";
			while (br.ready()) {
				s = br.readLine();
				pw.println(s);
			}
			pw.close();
			br.close();
		} catch (IOException e) {
			
		}
	}
	
	public static void writeToFile(BufferedReader br){
		String s = "";
		try {
			FileWriter fw  = new FileWriter("E://nvhserver.txt");
			PrintWriter bw = new PrintWriter(fw);
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				bw.println(s);
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
