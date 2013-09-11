package com.nvh.sever;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UpdSever {

	private byte[] buffer;
	private int port;
	DatagramSocket socket;
	int size;

	public UpdSever(int port, int size) throws SocketException {
		super();
		this.port = port;
		this.size = size;
		buffer = new byte[size];
		socket = new DatagramSocket(port);
		System.out.println("Server is ready.....");
	}

	public UpdSever(int port) throws SocketException {
		super();
		this.port = port;
		buffer = new byte[128];
		socket = new DatagramSocket(port);
	}

	public void run() {
		while (true) {
			DatagramPacket dpk = new DatagramPacket(buffer, buffer.length);
			try {
				socket.receive(dpk);
				String s = new String(dpk.getData(), 0, dpk.getLength());
				System.out.println("From " + dpk.getSocketAddress());
				System.out.println(s);
				if (s.equals("+QUIT")){
					System.out.println("Server Shut Down!");
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		socket.close();
	}

	public UpdSever(byte[] buffer, int port, DatagramSocket socket, int size) {
		super();
		this.buffer = buffer;
		this.port = port;
		this.socket = socket;
		this.size = size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UpdSever mSever = new UpdSever(5000,512);
			mSever.run();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
