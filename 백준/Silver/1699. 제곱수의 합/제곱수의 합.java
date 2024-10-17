import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N + 1];

		d[1] = 1;
		
		for(int i=2;i<=N; i++) {
			d[i] = Integer.MAX_VALUE;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if(i-j*j==0) {
					d[i] = 1;
				}
				d[i] = Math.min(d[i], d[i - j * j] + d[j * j]);			
			}
		}
		
		System.out.println(d[N]);
	}
}