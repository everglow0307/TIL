package com.study.java;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackAndQueue {

	// Queue는 Interface이기 때문에 new연산자를 사용할 수 없다.
	// Stack은 클래스이기 때문에 new 연산자로 객체를 만들고, push/pop/peek메소드를 사용할 수 있다.
	
	// Queue를 구현한 클래스를 사용하기
	// 큐를 구현한 클래스 목록에는 LinkedList가 있음.
	
	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList(); // Queue인터페이스의 구현체인 LinkedList
	
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
		
		
		// Stack의 활용 
		/**
		 * 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로
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
				System.out.println("괄호가 일치합니다.");
			}else {
				System.out.println("괄호가 일치하지 않습니다.");
			}
		}catch(EmptyStackException e) {
			System.out.println("괄호가 일치하지 않습니다.");
			//닫는 괄호가 열린 괄호개수보다 많아서 빈 stack에서 pop할 경우 예외 발생
		}
		
		
		//Queue의 활용
		/**
		 * 최근사용문서, 인쇄작업 대기목록, 
		 * */
		
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(true) {
			System.out.println(">>");
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();
				//trim()은 문자열 양 옆의 공백만 삭제하고 문자열 중간의 공백은 삭제하지 않는다.
				
				if("".equals(input)) continue;
				
				if(input.equalsIgnoreCase("q")){
					System.exit(0);
				}else if(input.equalsIgnoreCase("help")) {
					System.out.println("help - 도움말을 보여줍니다.");
					System.out.println("q - 종료");
					System.out.println("h - 최근 입력한 명령어를 "+QueueEx.MAX_SIZE+"개 보여줍니다.");
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
				System.out.println("입력 오류입니다.");
			}
		}// end while
	} //main()
	public static void save(String input) {
		//queue에 저장한다.
		/**
		 * "".equals(input)이라고 하는 이유는, 
		 * input!=null&&input.equals("")를 줄이기 위함이다.
		 * ""를 앞에 넣어야 input값이 null일 때 nullpointerException이 뜨지 않는다.
		 * "".equals(null)은 예외가 발생하지 않지만, null.equals("")는 예외가 발생하기 때문.
		 * */
		if(!"".equals(input)) 
			QueueEx.q.offer(input);
		

		// queue의 최대크기를 넘으면 처음 입력된 값을 삭제
		if(QueueEx.q.size() > QueueEx.MAX_SIZE)
			QueueEx.q.remove();
	}
	
}


	
class QueueEx{
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
}
