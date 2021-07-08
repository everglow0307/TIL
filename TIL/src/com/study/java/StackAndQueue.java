package com.study.java;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackAndQueue {

	// Queue�� Interface�̱� ������ new�����ڸ� ����� �� ����.
	// Stack�� Ŭ�����̱� ������ new �����ڷ� ��ü�� �����, push/pop/peek�޼ҵ带 ����� �� �ִ�.
	
	// Queue�� ������ Ŭ������ ����ϱ�
	// ť�� ������ Ŭ���� ��Ͽ��� LinkedList�� ����.
	
	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList(); // Queue�������̽��� ����ü�� LinkedList
	
		st.push("0");
		st.push("1");
		st.push("2");
		
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("======Stack=======");
		while(!st.empty()) {
			System.out.println(st.pop());
		}
		
		System.out.println("======Queue=======");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		
		// Stack�� Ȱ�� 
		/**
		 * ���İ��, ���İ�ȣ�˻�, �������μ����� undo/redo, ���������� �ڷ�/������
		 * */
		
		Stack st2 = new Stack();
		String expression = "((3+5*8-2)+1)";
		
		System.out.println("expression: "+expression);
		
		try {
			for(int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				
				if(ch == '(') {
					st.push(ch+"");
				}else if(ch == ')') {
					st.pop();
				}
			}
			
			if(st.isEmpty()) {
				System.out.println("��ȣ�� ��ġ�մϴ�.");
			}else {
				System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}catch(EmptyStackException e) {
			System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�.");
			//�ݴ� ��ȣ�� ���� ��ȣ�������� ���Ƽ� �� stack���� pop�� ��� ���� �߻�
		}
		
		
		//Queue�� Ȱ��
		/**
		 * �ֱٻ�빮��, �μ��۾� �����, 
		 * */
		
		System.out.println("help�� �Է��ϸ� ������ �� �� �ֽ��ϴ�.");
		
		while(true) {
			System.out.println(">>");
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();
				//trim()�� ���ڿ� �� ���� ���鸸 �����ϰ� ���ڿ� �߰��� ������ �������� �ʴ´�.
				
				if("".equals(input)) continue;
				
				if(input.equalsIgnoreCase("q")){
					System.exit(0);
				}else if(input.equalsIgnoreCase("help")) {
					System.out.println("help - ������ �����ݴϴ�.");
					System.out.println("q - ����");
					System.out.println("h - �ֱ� �Է��� ��ɾ "+QueueEx.MAX_SIZE+"�� �����ݴϴ�.");
				}else if(input.equalsIgnoreCase("history")) {
					save(input);
					
					
					LinkedList list = (LinkedList)q;
					
					for(int i=0; i<list.size(); i++) 
						System.out.println((i+1)+"."+list.get(i));
				}else {
					save(input);
					System.out.println(input);
				}
			}catch(Exception e) {
				System.out.println("�Է� �����Դϴ�.");
			}
		}// end while
	} //main()
	public static void save(String input) {
		//queue�� �����Ѵ�.
		/**
		 * "".equals(input)�̶�� �ϴ� ������, 
		 * input!=null&&input.equals("")�� ���̱� �����̴�.
		 * ""�� �տ� �־�� input���� null�� �� nullpointerException�� ���� �ʴ´�.
		 * "".equals(null)�� ���ܰ� �߻����� ������, null.equals("")�� ���ܰ� �߻��ϱ� ����.
		 * */
		if(!"".equals(input)) 
			QueueEx.q.offer(input);
		

		// queue�� �ִ�ũ�⸦ ������ ó�� �Էµ� ���� ����
		if(QueueEx.q.size() > QueueEx.MAX_SIZE)
			QueueEx.q.remove();
	}
	
}


	
class QueueEx{
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
}
