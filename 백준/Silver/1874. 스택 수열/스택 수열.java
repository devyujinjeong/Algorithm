import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] numArray = new int[N];
		Stack<Integer> numStack = new Stack<>();
		int num =1;
		boolean result = true; 
		
		for(int i=0; i<N; i++) {
			numArray[i] = Integer.parseInt(br.readLine());; // 만들고자 하는 수열을 배열에 저장하기
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
					result = false;
					break;
				}else {
					sb.append("-\n");
				}
			}			
		}

		if (result) {
			System.out.println(sb.toString());
		}else {
			System.out.println("NO");
		}
	}
}