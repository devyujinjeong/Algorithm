import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long mod = 1000000000;
		long result = 0;
		
		long[][] D = new long[N+1][11];
		
		for(int i=1; i<=9; i++) {
			D[1][i]= 1;
		}
		
		for(int i=2; i<=N; i++) {
			D[i][0] = D[i-1][1];
			D[i][9] = D[i-1][8];
			for(int h=1; h<9; h++) {
				D[i][h] = (D[i-1][h-1]+D[i-1][h+1])%mod;
			}
		}
		
		for(int i=0; i<=9; i++) {
			result = (result+D[N][i])%mod;
		}
		
		System.out.println(result);	
	}
}