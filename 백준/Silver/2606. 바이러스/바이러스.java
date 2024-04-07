import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] array; // 인접행렬로 표현
	static boolean[] visited; // 방문한 노드를 표시할 배열
	static int count; // 감염된 컴퓨터의 개수 세기
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt(); // computer의 개수
		int e = sc.nextInt(); // 연결된 선의 개수
		
        array = new int[v+1][v+1]; // 배열 초기화
        
		// 컴퓨터끼리 선으로 연결하기
		for(int i=0; i<e; i++) {
			int a = sc.nextInt();
	        int b = sc.nextInt();
	        
	        // 연결되어 있는 경우 행렬에 1로 표시하기
	        array[a][b] = 1; array[b][a] =1;
		}
		
		// 방문 여부를 나타내는 배열 초기화
        visited = new boolean[v + 1];
		bfs(1);
		
	}
	
	// 너비 우선 탐색(Breadth First Search) 메서드
    private static void bfs(int v){
        Queue<Integer> queue = new LinkedList<Integer>(); // 큐 생성
        queue.offer(v); // 시작 노드를 큐에 삽입
        visited[v] = true; // 시작 노드를 방문했음을 표시

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            int n = queue.poll(); // 큐에서 하나의 노드를 꺼냄

            // 현재 노드와 연결된 모든 노드를 탐색
            for(int i = 1; i < array.length; i++) {
                // 연결된 노드이면서 아직 방문하지 않은 노드일 경우
                if(array[n][i] == 1 && visited[i] == false) {
                    visited[i] = true; // 해당 노드를 방문했음을 표시
                    count++;
                    queue.offer(i); // 큐에 해당 노드를 삽입
                }
            }
        }   
        System.out.println(count);

    }

}
