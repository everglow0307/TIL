package com.study.java;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	InputStream is;
	OutputStream os;
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Scanner sc;
	String rMsg;
	
	public void start() {
		try {
			socket = new Socket("localhost",5000);
			sendMessage(socket);
			receiveMessage(socket);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void receiveMessage(Socket socket) {
		try {
			is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			rMsg = (String)ois.readObject();
			System.out.println(rMsg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sendMessage(Socket socket) {
		try {
		
			os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
			sc = new Scanner(System.in);
			System.out.println("보낼 메세지 : ");
			String sMsg = sc.next();
			oos.writeObject(sMsg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TCPClient tcpClient = new TCPClient();
		tcpClient.start();
	}
}
