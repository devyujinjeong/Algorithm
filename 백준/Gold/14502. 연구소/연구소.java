import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] center;
    static ArrayList<int[][]> arr;
    static int answer;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        center = new int[N][M];
        arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                center[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findWall(center, 0, 0);

        for(int[][] wall : arr) {
            int region = findSafeRegion(wall);
            if(answer < region) answer = region;
        }

        System.out.println(answer);
    }

    /**
    * 벽을 세울 수 있는 모든 경우의 수를 찾아서 arr에 배열 저장하는 메소드
    * */
    static void findWall(int[][] cur, int depth, int start) {
        if (depth == 3) {
            int[][] copy = new int[N][M];
            for (int i = 0; i < N; i++) copy[i] = cur[i].clone(); // 깊은 복사
            arr.add(copy);
            return;
        }

        for (int k = start; k < N * M; k++) {
            int i = k / M;
            int j = k % M;
            if (cur[i][j] == 0) {
                cur[i][j] = 1;
                findWall(cur, depth + 1, k + 1); 
                cur[i][j] = 0;
            }
        }
    }

    /**
    * 안전 지역의 크기를 찾는 메소드
    * */
    static int findSafeRegion(int[][] center) {
        Queue<Node> q = new LinkedList<>();

        // 바이러스가 있는 부분을 q에 넣기
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(center[i][j] == 2) {
                    q.add(new Node(i,j));
                }
            }
        }

        // 2와 0이 닿아 있는 부분 바이러스 전염시키기
        while(!q.isEmpty()) {
            Node temp = q.poll();
            for(int i=0; i<4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue; // 범위에서 벗어나지 않게 하기 위함

                if(center[nx][ny] !=0 ) continue;

                center[nx][ny] = 2;
                q.add(new Node(nx, ny));
            }
        }

        int count = 0;
        // 0인 영역의 크기 찾기
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(center[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;

    }

    /**
    * 위치를 저장하기 위한 Node 클래스
    * */
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}