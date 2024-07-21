import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Queue<Integer> print = new LinkedList<Integer>();
			Queue<Integer> index = new LinkedList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<a; j++) {
				int num = Integer.parseInt(st.nextToken());
				print.add(num);
				index.add(j);
			}
		
			int count = 1; 
			while(!print.isEmpty()) {
				int max = Collections.max(print);
				
				if(max == print.peek()) { 
					print.poll();
					if(index.poll()==b) {
						break;
					}
					count++;					
				}else {
					print.add(print.poll());
					index.add(index.poll());
				}
			}
			System.out.println(count);
		}
	}
}