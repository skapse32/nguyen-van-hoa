package com.nvh.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.nvh.Thread.TCPThread;
import com.nvh.readwrite.socket.BinaryData;

public class TCPServer {

	private ServerSocket socket;

	public TCPServer(int port) throws IOException {
		socket = new ServerSocket(port);
		System.out.println("Server is ready.....");
	}

	public void run() throws IOException {
		try {
			int cnt = 0;
			while(true){
				Socket connection = socket.accept();
				System.out.println("Accept connection from "
					+ connection.getRemoteSocketAddress());
				new TCPThread(connection, cnt);
				cnt++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		socket.close();
	}
}
