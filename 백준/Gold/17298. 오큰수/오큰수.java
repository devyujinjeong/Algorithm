import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N]; 
		int[] ans = new int[N]; // 정답을 출력하기 위한 배열
		Stack<Integer> index = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		index.push(0);
		
		for(int i=0; i<N; i++) {
			// index를 저장하는 스택이 비어있지 않고, 오른쪽에 있는 숫자가 더 큰 경우
			while(!index.isEmpty()&&num[index.peek()]<num[i]) {
				ans[index.pop()] = num[i];
			}
			index.push(i);
		}
		
		while(!index.isEmpty()) {
			ans[index.pop()] = -1;
		}
		
		for(int i : ans) {
			bw.write(i+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}