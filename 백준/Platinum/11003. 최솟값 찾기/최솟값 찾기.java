import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Node> num = new LinkedList<Node>();
		
		st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			while(!num.isEmpty()&&num.getLast().value>a) {
				num.removeLast();
			}
			
			num.addLast(new Node(a, i));
			
			if(num.getFirst().index<=i-L) {
				num.removeFirst();
			}
			
			bw.write(num.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
	
	static class Node {
		public int value;
		public int index;

		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}