import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] D = new int[11];
		
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		for(int i=4; i<=10; i++) {
			D[i] = D[i-1]+D[i-2]+D[i-3];
		}
		
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(D[a]+"\n");
		}
		System.out.println(sb);

	}
}