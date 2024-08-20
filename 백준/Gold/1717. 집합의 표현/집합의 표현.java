import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] num;

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a!=b) {
			num[b]=num[a];
		}		
	}

	static int find(int a) {
		if (num[a] == a) {
			return a;
		} else {
			return find(num[a]);
		}
	}
	
	static boolean checkSamePnode(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		num = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			num[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (w == 0) {
				union(a, b);
			} else {
				if (checkSamePnode(a,b)) {
					bw.write("YES" + "\n");
				} else {
					bw.write("NO" + "\n");
				}
			}
		}

		bw.flush();
		bw.close();
	}
}