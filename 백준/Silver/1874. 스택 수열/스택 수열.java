import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int[] numArray = new int[N];
		Stack<Integer> numStack = new Stack<>();
		int num =1;
		boolean result = true; 
		
		for(int i=0; i<N; i++) {
			numArray[i] = sc.nextInt(); // 만들고자 하는 수열을 배열에 저장하기
		}
				
		for(int i=0; i<N; i++) {
			int a = numArray[i];
			if(num<=a) {
				while(num<=a) {
					numStack.push(num++);
					sb.append("+\n");
				}
				numStack.pop(); // 가장 나중에 들어간 숫자 빼기 
				sb.append("-\n");
			}else {
				int n = numStack.pop(); // 일단 가장 위에 있는 숫자를 빼야함
				if(n>a) {
					System.out.println("NO");
					result = false;
					break;
				}else {
					sb.append("-\n");
				}
			}			
		}

		if (result) {
			System.out.println(sb.toString());
		}
	}
}