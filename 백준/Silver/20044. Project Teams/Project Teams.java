import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] s = new int[2*n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<2*n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(s);
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			if(min>s[i]+s[2*n-i-1]) {
				min = s[i]+s[2*n-i-1];
			}
		}
		
		System.out.println(min);
	}
}