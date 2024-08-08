import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A); // 데이터 정렬하기
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			boolean result = false;
			
			int first = 0;
			int end = N-1;
			
			while(first<=end) {
				int mid = (first+end)/2;
				if(A[mid]>target) {
					end = mid -1;
				}else if(A[mid]<target) {
					first = mid+1;
				}else {
					result = true;
					break;
				}				
			}
			
			bw.write(result?"1"+"\n":"0"+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}
