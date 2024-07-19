import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] numArray = new int[N];
		ArrayList<String> signList = new ArrayList<String>();
		Stack<Integer> numStack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			numArray[i] = sc.nextInt(); // 만들고자 하는 수열을 배열에 저장하기
		}
				
		int num =1;
		
		for(int i=0; i<N; i++) {
			int a = numArray[i];
			if(num<=a) {
				while(num<=a) {
					numStack.push(num++);
					signList.add("+");
				}
				numStack.pop(); // 가장 나중에 들어간 숫자 빼기 
				signList.add("-");
			}else {
				int n = numStack.pop(); // 일단 가장 위에 있는 숫자를 빼야함
				if(n>a) {
					signList.add("NO");
					break;
				}else {
					signList.add("-");
				}
			}
			
		}

		if(signList.contains("NO")) {
			System.out.println("NO");
		}else {
			for(String i:signList) {
				System.out.println(i);
			}
		}		
	}
}