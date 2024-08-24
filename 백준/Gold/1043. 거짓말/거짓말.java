import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			p[b] = a;
		}
	}

	static int find(int c) {
		if (p[c] != c) {
			p[c] = find(p[c]);
		}

		return p[c];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<int[]> peopleList = new ArrayList<>();
		p = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int[] know = new int[k + 1];
		for (int i = 1; i <= k; i++) {
			know[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < k; i++) {
			union(know[i], know[i + 1]);
		}

		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] party = new int[num + 1];
			for (int j = 1; j <= num; j++) {
				party[j] = Integer.parseInt(st.nextToken());
			}

			peopleList.add(party);

			for (int l = 1; l < num; l++) {
				union(party[l], party[l + 1]);
			}
		}
		
		int count = 0;
		for (int[] array : peopleList) {
			boolean canLie = true;
			for(int i=1; i<array.length; i++) {
				if(know.length!=1) {
					if(find(array[i])==find(know[1])) {
						canLie = false;
						break;
					}					
				}
			}
			
			if(canLie) {
				count++;
			}			
		}
		
		System.out.println(count);
	}
}
