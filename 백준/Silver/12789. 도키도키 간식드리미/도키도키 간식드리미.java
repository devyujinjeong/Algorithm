import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Queue<Integer> line = new LinkedList<>(); // 현재 줄 서있는 곳
		Stack<Integer> snack = new Stack<>(); // 한 명씩만 설 수 있는 공간
		
		for(int i=0; i<n; i++) {
			line.add(sc.nextInt());
		}
		
		int target = 1;
		
		while(!line.isEmpty()) {
			if(line.peek()==target) { // line의 첫번째 사람이 target과 일치하는 경우
				line.poll();
				target++;
			}else if(!snack.isEmpty()&&snack.peek()==target) { 
				// snack이 비어있지 않으며, snack에 마지막으로 들어온 사람과 target이 일치하는 경우
				snack.pop();
				target++;
			}else {
				snack.push(line.poll());
			}
		}
		
		while(!snack.isEmpty()) {
			if(snack.peek()==target) {
				snack.pop();
				target++;
			}else {
				System.out.println("Sad");
				return;
			}
		}	
		System.out.println("Nice");
	}
}
