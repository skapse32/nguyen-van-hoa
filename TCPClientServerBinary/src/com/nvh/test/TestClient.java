package com.nvh.test;

import java.util.Scanner;

import com.nvh.client.TCPClient;

public class TestClient {

	public static void main(String[] args){
		TCPClient mClient = new TCPClient("localhost", 5000);
		Scanner mScanner = new Scanner(System.in);
		String input;
		while(!(input = mScanner.nextLine()).equals("exit")){
			System.out.println(input);
			mClient.run(input);
		}
		System.out.println("Client exit!");
	}
	
}
