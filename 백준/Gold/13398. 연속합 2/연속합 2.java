import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	
		int[] D = new int[N];
		int[] L = new int[N];
		int[] R = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		L[0] = D[0];
		int result = L[0];
		for(int i=1; i<N; i++) {
			L[i] = Math.max(D[i], L[i-1]+D[i]);
			result = Math.max(result, L[i]);
		}
		
		R[N-1] = D[N-1];
		for(int i=N-2; i>=0; i--) {
			R[i] = Math.max(D[i], R[i+1]+D[i]);
		}
		
		for(int i=1; i<N-1; i++) {
			int temp = L[i-1]+R[i+1];
			result = Math.max(result, temp);
		}
		
		System.out.println(result);		
	}
}