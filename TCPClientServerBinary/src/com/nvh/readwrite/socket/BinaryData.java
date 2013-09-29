package com.nvh.readwrite.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BinaryData {

	public void read(Socket connection, String outputFile){
		//doc file va ghi file
		int size = 1024;
		byte[] buffer = new byte[size];
		//Get inputstream from socket;
		try {
			InputStream is = connection.getInputStream();
			//create bufferd stream
			BufferedInputStream bis = new BufferedInputStream(is);
			//read from buffer
			int count;
			//vua doc file tu buffer va ghi xuong file
			long byteWrote = 0;
			FileOutputStream os = new FileOutputStream(outputFile);
			while((count = bis.read(buffer))!= -1){
				WriteToServer(os,count,buffer);
				byteWrote += count;
			}
			System.out.println("Server wrote " + byteWrote + " byte(s)" );
			bis.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	


	public static void write(Socket connection,String localtionFile){
		//nhiem vu la doc file tu client roi gui len server
		try {
			byte[] buffer = new byte[1024];
			File filein = new File(localtionFile);
			System.out.println("File size is " + filein.length() + " bytes");
			FileInputStream is = new FileInputStream(filein);
			int byteRead;
			OutputStream os = connection.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);
			while((byteRead = is.read(buffer)) != -1){
				WriteBuffer(buffer, bos, byteRead);
			}
			bos.close();
			os.close();
			connection.close();
			System.out.println("Sent to server!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void WriteBuffer(byte[] buffer,BufferedOutputStream bos, int byteRead){
		try {
			bos.write(buffer, 0, byteRead);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void WriteToServer(FileOutputStream os, int count,
			byte[] buffer) {
		// TODO Auto-generated method stub
		try {
			os.write(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
