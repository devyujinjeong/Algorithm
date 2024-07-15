import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];
		int first = 0, end = N-1, count=0;
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numArr);
		
		int sum = Integer.parseInt(br.readLine());
		
		while(first<end) {
			int check = numArr[first]+numArr[end];
			if(check==sum) {
				first++;
				end--;
				count++;
			}else if(check>sum) {
				end--;
			}else {
				first++;
			}
		}
        
		System.out.println(count);	
	}
}