import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long count = 0, M = 0, sum = 0;
		
		long[] numList = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numList);

		for (int i = 0; i < N; i++) {
			M = numList[i];
			int start = 0;
			int end = N-1;
			while (start < end) {
				sum = numList[start] + numList[end];
				if (sum == M) {
					if(start!=i&&end!=i) {
						count++;
						break;						
					}else if(start == i) {
						start++;
					}else if(end==i) {
						end--;
					}
				} else if (sum > M) {
					end--;
				} else {
					start++;
				}
			}
		}
		System.out.println(count);
	}
}