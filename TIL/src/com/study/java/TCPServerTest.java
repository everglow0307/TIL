package com.study.java;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTest extends Thread{

	/**
	 * TCP통신을 위해서 자바에서는 ServerSocket과 Socket클래스를 제공.
	 * ServerSocket이 서버역할을 담당하고, Socket은 클라이언트에서 서버 쪽 호스트를 연결하는 용도로 사용.
	 * 
	 * InetAddress클래스는 특정 IP주소를 다루기 위한 클래스.
	 * */
	
	private InputStream is;
	private OutputStream os;
	private ServerSocket serverSocket;
	private ObjectInputStream ois;
	ObjectOutputStream oos;
	Socket socket;
	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(5000);
			while(true) {
				System.out.println("요청 대기");
				socket = serverSocket.accept();
				System.out.println("접속한 클라이언트 : "+socket.getInetAddress());
				is = socket.getInputStream();
				os = socket.getOutputStream();
				ois = new ObjectInputStream(is);
				oos = new ObjectOutputStream(os);
				String msg =(String)ois.readObject();
				System.out.println("클라이언트에서 보낸 메세지: "+msg);
				String retMsg = "서버로부터 되돌아온 메세지 : "+msg;
				
				oos.writeObject(retMsg);
				socket.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TCPServerTest().start();
		
	}
}
