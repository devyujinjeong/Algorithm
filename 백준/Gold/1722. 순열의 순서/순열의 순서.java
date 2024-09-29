import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] F = new long[21];
		int[] S = new int[21];
		boolean[] visited = new boolean[21];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		F[0] = 1;
		for (int i = 1; i <= N; i++) {
			F[i] = F[i - 1] * i; // 팩토리얼 경우의 수 초기화하기
		}

		if (a == 1) {
			long K = Long.parseLong(st.nextToken()); // k번째
			for(int i=1;i<=N;i++) {
				for(int j=1, cnt=1; j<=N; j++) {
					if(visited[j]) {continue;}
					
					if(K<=cnt*F[N-i]) {
						K-=((cnt-1)*F[N-i]);
						S[i] = j;
						visited[j] = true;
						
						break;
					}
					cnt++;
				}
			}
			for(int i=1; i<=N; i++) {
				System.out.print(S[i]+" ");
			}
			
		} else if (a == 2) {
			long K = 1;
			for (int i = 1; i <= N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
				long cnt = 0;
				for(int j=1; j<S[i]; j++) {
					if(!visited[j]) {
						cnt++;
					}
				}
				K+=cnt*F[N-i];
				visited[S[i]] = true;

			}
			System.out.println(K);
		}
	}
}