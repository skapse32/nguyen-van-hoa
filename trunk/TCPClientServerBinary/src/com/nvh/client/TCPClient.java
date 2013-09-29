package com.nvh.client;

import java.io.IOException;
import java.net.Socket;

import com.nvh.readwrite.socket.BinaryData;

public class TCPClient {
	private Socket socket;
	
	public TCPClient(String host , int port){
		try {
			socket = new Socket(host, port);
			System.out.println("Connected to server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(String command){
		
		BinaryData.write(socket, command);
	}
}
