import java.io.*;
import java.util.*;

public class Main{
	
	static int N,last = 0;
	static Queue<Integer> queue = new LinkedList<Integer>();	//사용할 큐
	static StringBuilder sb = new StringBuilder();	//결과
	
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader를 통해 입력 값 받기
    	
        //--------입력값 저장 및 함수 실행------
    	N = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		String text = st.nextToken();
    		if(text.equals("push")) {
    			int temp = Integer.parseInt(st.nextToken());
    			push(temp);
    		}
            else if(text.equals("pop"))
    			pop();
    		else if(text.equals("size"))
    			size();
    		else if(text.equals("empty"))
    			empty();
    		else if(text.equals("front"))
    			front();
    		else if(text.equals("back"))
    			back();
    	}
    	System.out.println(sb.toString());	//결과 출력
    	br.close();
	}
	
    //push : 숫자 추가하기
	public static void push(int n) {
		queue.offer(n);
		// 마지막에 만들 back을 위해서 사용하는 변수
		last = n;
	}
	
    //pop : -1 출력 혹은 앞에 있는 정수 제거 후 출력
	public static void pop() {
		if(queue.isEmpty())
			sb.append("-1\n");
		else {
			int temp = queue.poll();
			sb.append(temp + "\n");
		}
	}
	
    //size : queue의 사이즈 출력
	public static void size() {
		sb.append(queue.size() + "\n");
	}
	
    //empty : 비어있는지 안비어있는지 검사하기
	public static void empty() {
		if(queue.isEmpty()) {
			sb.append("1\n");
		}
		else {
			sb.append("0\n");
		}
	}
	
   //front : 맨앞의 값을 출력, 없다면 -1
	public static void front() {
		if(queue.isEmpty())
			sb.append("-1\n");
		else
			sb.append(queue.peek() + "\n");
	}
	
    //back : 맨뒤의 값을 출력, 없다면 -1
	public static void back() {
		if(queue.isEmpty())
			sb.append("-1\n");
		else
			sb.append(last + "\n");
	}
}