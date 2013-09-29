package com.nvh.Thread;

import java.io.IOException;
import java.net.Socket;

import com.nvh.readwrite.socket.BinaryData;
import com.nvh.readwrite.socket.StringData;

public class TCPThread extends Thread {
	private Socket connection;
	private int id;

	public TCPThread(Socket conn, int cnt) {
		this.connection = conn;
		this.id = cnt;
		start();
	}

	@Override
	public void run() {

		super.run();
		// TODO Auto-generated method stub
		try {
			System.out.println("Data From Connection " + id);
			String localtion = StringData.Read(connection);
			BinaryData.read(connection, localtion);
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			interrupt();
			System.out.println("Thread " + id + "close!");
		}
	}

}
