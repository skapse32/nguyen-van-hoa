package com.nvh.Thread;

import java.io.IOException;
import java.net.Socket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
			ApplicationContext mContext = new ClassPathXmlApplicationContext("beans.xml");
			BinaryData mBinaryData = (BinaryData)mContext.getBean("binaryData");
			mBinaryData.read(connection, localtion);
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();;
			System.out.println("Thread " + id + "close!");
		}
	}

}
