package com.nvh.test;

import java.util.Scanner;

import com.nvh.client.TCPClient;

public class TestClient {

	public static void main(String[] args){
		TCPClient mClient = new TCPClient("localhost", 5000);
		System.out.println("Nhap vi tri file can gui len server : ");
		Scanner mScanner = new Scanner(System.in);
		String srcFile = mScanner.nextLine();
		String destFile = mScanner.nextLine();
		mClient.run(srcFile, destFile);
		System.out.println("Client exit!");
	}
	
}
