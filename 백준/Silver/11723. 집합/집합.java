import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Set<Integer> num = new HashSet<Integer>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int x;
			switch (s) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				num.add(x);
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				num.remove(x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if(num.contains(x)) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if(num.contains(x)) {
					num.remove(x);
				}else {
					num.add(x);
				}
				break;
			case "all":
				for(int j=1; j<=20; j++) {
					num.add(j);
				}
				break;
			case "empty":
				num.clear();
				break;
			}
		}
		System.out.println(sb);
	}
}
