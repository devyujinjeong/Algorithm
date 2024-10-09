import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] DP = new int[n+1][m+1];
		int max = 0;
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			for(int j=1; j<=m; j++) {
				DP[i][j] = (int)a.charAt(j-1)-48;
				if(DP[i][j]==1) {
					DP[i][j] = DP[i][j]+Math.min(Math.min(DP[i-1][j], DP[i][j-1]),DP[i-1][j-1]);
				}else {
					DP[i][j]=0;
				}
				max = Math.max(max, DP[i][j]);
			}
		}
		
		int size = max*max;
		
		System.out.println(size);
		
	}
}
