package com.study.java;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTest extends Thread{

	/**
	 * TCP����� ���ؼ� �ڹٿ����� ServerSocket�� SocketŬ������ ����.
	 * ServerSocket�� ���������� ����ϰ�, Socket�� Ŭ���̾�Ʈ���� ���� �� ȣ��Ʈ�� �����ϴ� �뵵�� ���.
	 * 
	 * InetAddressŬ������ Ư�� IP�ּҸ� �ٷ�� ���� Ŭ����.
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
				System.out.println("��û ���");
				socket = serverSocket.accept();
				System.out.println("������ Ŭ���̾�Ʈ : "+socket.getInetAddress());
				is = socket.getInputStream();
				os = socket.getOutputStream();
				ois = new ObjectInputStream(is);
				oos = new ObjectOutputStream(os);
				String msg =(String)ois.readObject();
				System.out.println("Ŭ���̾�Ʈ���� ���� �޼���: "+msg);
				String retMsg = "�����κ��� �ǵ��ƿ� �޼��� : "+msg;
				
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
