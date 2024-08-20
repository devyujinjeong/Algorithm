import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] sender = {0,0,1,1,2,2};
	static int[] receiver = {1,2,0,2,0,1};
	static int[] water;
	static boolean[][] visited;
	static boolean[] answer;
	
	static void BFS() {
		Queue<AB> q = new LinkedList<AB>();
		q.add(new AB(0,0));
		visited[0][0] = true;
		answer[water[2]] = true;
		
		while(!q.isEmpty()) {
			AB p = q.poll();
			int A = p.A;
			int B = p.B;
			int C = water[2]-A-B;
			
			for(int i=0; i<6; i++) { // A->B, A->C, B->C, B->A, C->A, C->B 
				int[] next = {A,B,C};
				next[receiver[i]]+= next[sender[i]];
				next[sender[i]] =0;
				
				if(next[receiver[i]]>water[receiver[i]]) { // 물이 넘치게 되는 경우
					// 초과하는 물을 다시 이전의 물통에 넣어주기
					next[sender[i]] = next[receiver[i]] - water[receiver[i]];
					// 물의 양을 다시 최대로 채워넣기
					next[receiver[i]] = water[receiver[i]];
				}
				
				if(!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					q.add(new AB(next[0],next[1]));
					if(next[0]==0) {
						answer[next[2]] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		water = new int[] {A,B,C};
		
		visited = new boolean[201][201];
		answer = new boolean[201];
		
		BFS();
		for(int i=0; i<answer.length;i++) {
			if(answer[i]) {
				System.out.print(i+" ");
			}
		}
	}
}

// A와 B의 무게만 안다면 C의 무게는 자동적으로 알 수 있음
class AB{
	int A;
	int B; 
	
	public AB(int A, int B) {
		super();
		this.A = A;
		this.B = B;
	}
}