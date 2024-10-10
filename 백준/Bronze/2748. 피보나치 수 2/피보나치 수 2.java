import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long [] F = new long[n+1];
	
		F[0] = 0;
		F[1] = 1;
		
		for(int i=2; i<=n; i++) {
			F[i] = F[i-1]+F[i-2];
		}
		
		System.out.println(F[n]);
	}
}