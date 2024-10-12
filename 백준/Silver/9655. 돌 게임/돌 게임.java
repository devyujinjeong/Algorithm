import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
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