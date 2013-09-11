package com.nvh.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UpdClient {

	int port;
	DatagramPacket dpk;
	DatagramSocket socket;
	int size;
	byte[] buffer;
	private String content;
	
	public UpdClient(int port, String content) {
		super();
		this.port = port;
		this.content = content;
		buffer = content.getBytes();
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(){
		buffer = content.getBytes();
		InetAddress ia;
		try {
			ia = InetAddress.getByName("localhost");
			dpk = new DatagramPacket(buffer, buffer.length, ia, port);
			socket.send(dpk);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner mScanner = new Scanner(System.in);
		System.out.println("Input your content : ");
		String content = mScanner.nextLine();
		UpdClient mClient = new UpdClient(5000, content);
		mClient.run();
	}

}
