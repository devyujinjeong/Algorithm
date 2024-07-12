import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long count = 0;
		long sum = 0;
		long[] C = new long[M];
				
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sum+=Integer.parseInt(st.nextToken());
			long r = sum % M;
			if(r==0) {
				count++;
			}
			C[(int)r]++;
		}
		
		for(int i=0; i<M ;i++) {
			if(C[i]>1) {
				count +=(long)(C[i]*(C[i]-1)/2);
			}
		}
		System.out.println(count);
	}
}