import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N+2];
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N; i>0; i--) {
			if(i+T[i]>N+1) { // 지정된 날까지 일을 끝내지 못하는 경우
				D[i] = D[i+1];
			}else {
				D[i] = Math.max(D[i+1], D[i+T[i]]+P[i]);
			}
		}
		System.out.println(D[1]);
	}
}