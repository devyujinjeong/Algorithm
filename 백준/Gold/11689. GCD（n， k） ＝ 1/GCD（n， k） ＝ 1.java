import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		long result = N;
		
		for(long i=2; i<=Math.sqrt(N);i++) {
			if(N%i==0) { // 소인수인 경우라면
				result = result - result/i;
				while(N%i==0) { // 만약에 2*5인 경우에 5만 남기기 위해서
					N/=i;
				}
			}
		}
		
		// 만약 2*5를 생각하면, N이 5가 됐지만 10의 제곱근이 5보다 작아서 이부분이 진행되지 않는다.
		// 그래서 밑에 따로 코드를 작성해준다.
		if(N>1) {
			result = result - result/N;
		}	
		System.out.println(result);
	}
}
