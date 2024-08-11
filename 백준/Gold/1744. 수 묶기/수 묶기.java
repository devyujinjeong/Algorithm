import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long result = 0, zero =0, one=0;
		
		// 플러스일 경우와 마이너스일 경우에 계산 방식이 닮
		PriorityQueue<Integer> plus = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minus = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a>1) {
				plus.add(a);
			}else if(a<0) {
				minus.add(a);
			}else if(a==0) {
				zero++; // 0의 개수
			}else {
				one++;
			}
		}
		
		while(minus.size()>1) {
			int first = minus.poll();
			int second = minus.poll();
			
			result += first*second;
		}
		
		if(minus.size()==1) { // 마이너스인 숫자가 하나라도 남아 있는 경우라면
			if(zero>0) {
				result +=0;
			}else { // 만약 0이라는 숫자가 하나도 존재하지 않는다면
				result += minus.peek();
			}			
		}
		
		while(plus.size()>1) {
			int first = plus.poll();
			int second = plus.poll();
			
			result += first*second;
		}
		
		if(plus.size()==1) {
			result += plus.peek()+one;			
		}else {
			result+=one;
		}

		System.out.println(result);
		
	}

}
