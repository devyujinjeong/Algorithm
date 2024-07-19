import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=0; i<N; i++) {
			q.add(i+1);			
		}
		// 1. 가장 첫번째 값 지우기
		// 2. 첫번째 값을 바닥으로 옮기기 --> 숫자를 지우고 옮기기

		while(q.size()!=1) {
			q.remove();
			int a = q.peek();
			q.remove();
			q.add(a);
		}
		
		System.out.println(q.peek());
	}
}
