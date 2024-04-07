import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] array; // 인접행렬로 표현할 배열
    static boolean[] visited; // 방문한 노드를 표시할 배열

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 정점의 개수 입력
        int M = sc.nextInt();   // 간선의 개수 입력
        int V = sc.nextInt();   // 시작점 번호 입력

        array = new int[N+1][N+1]; // 배열 초기화

        // 간선 정보 입력 받기
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 연결된 노드를 1로 표시
            array[a][b] = 1;
            array[b][a] = 1;
        }

        // 방문 여부를 나타내는 배열 초기화 (노드 번호는 1부터 시작하기 때문에 N + 1)
        visited = new boolean[N + 1];
        // DFS 탐색 실행
        dfs(V);

        System.out.println(); // 줄바꿈

        visited = new boolean[N + 1]; // visited 배열 초기화

        // BFS 탐색 실행
        bfs(V);

        System.out.println(); // 줄바꿈
    }

    // 깊이 우선 탐색(Depth First Search) 메서드
    private static void dfs(int v) {
        visited[v] = true; // 현재 노드를 방문했음을 표시
        System.out.print(v + " "); // 현재 노드 출력

        // 현재 노드와 연결된 모든 노드를 탐색
        for(int j = 1; j < array.length; j++) {
            // 연결된 노드이면서 아직 방문하지 않은 노드일 경우
            if(array[v][j] == 1 && visited[j] == false) {
                // 해당 노드로 이동하여 재귀적으로 탐색 실행
                dfs(j);
            }
        }
    }

    // 너비 우선 탐색(Breadth First Search) 메서드
    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>(); // 큐 생성
        queue.offer(v); // 시작 노드를 큐에 삽입
        visited[v] = true; // 시작 노드를 방문했음을 표시

        System.out.print(v + " "); // 시작 노드 출력

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            int n = queue.poll(); // 큐에서 하나의 노드를 꺼냄

            // 현재 노드와 연결된 모든 노드를 탐색
            for(int i = 1; i < array.length; i++) {
                // 연결된 노드이면서 아직 방문하지 않은 노드일 경우
                if(array[n][i] == 1 && visited[i] == false) {
                    visited[i] = true; // 해당 노드를 방문했음을 표시
                    System.out.print(i + " "); // 해당 노드 출력
                    queue.offer(i); // 큐에 해당 노드를 삽입
                }
            }
        }   
    }
}
