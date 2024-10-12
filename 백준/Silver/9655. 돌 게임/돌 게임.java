import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		String[] D = new String[N+1];
		
		D[1] = "SK";
		
		for(int i=2; i<=N; i++) {
			if(D[i-1]=="SK") {
				D[i] = "CY";
			}else {
				D[i] = "SK";
			}
		}
		
		System.out.println(D[N]);		
	}
}