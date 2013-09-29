package com.nvh.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nvh.readwrite.socket.BinaryData;
import com.nvh.readwrite.socket.StringData;

public class TCPClient {
	private Socket socket;
	private String host;
	private int port;
	
	public TCPClient(){
		
	}
	
	public TCPClient(String host, int port) {
		this.host = host;
		this.port = port;
		try {
			socket = new Socket(host, port);
			System.out.println("Connected to server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(String srcFile, String destFile) {
		if (StringData.write(socket, destFile)) {
			try {
				BinaryData.write(socket, srcFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
