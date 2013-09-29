package com.nvh.test;

import java.io.IOException;

import com.nvh.server.TCPServer;

public class TestServer {

	public static void main(String[] args) throws IOException{
		TCPServer mServer =  new TCPServer(5000);
		mServer.run();
	}
	
}
