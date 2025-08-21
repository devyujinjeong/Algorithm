import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int T = Integer.parseInt(br.readLine());
            int count = 0;

            ArrayList<Integer>[] tree = new ArrayList[T+1];
            boolean[] visited = new boolean[T+1];

            for (int j = 1; j <= T; j++) {
                tree[j] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=1; k<=T; k++) {
                int a = Integer.parseInt(st.nextToken());
                // 양방향으로 값 넣기
                tree[k].add(a);
                tree[a].add(k);
            }

            Queue<Integer> q = new LinkedList<>();

            for(int a=1; a<=T; a++) {
                if(visited[a]) continue;

                q.add(a);
                visited[a] = true;

                while(!q.isEmpty()) {
                    int temp = q.poll();
                    for(int num : tree[temp]) {
                        if(visited[num]) continue;
                        q.add(num);
                        visited[num] = true;
                    }
                }

                count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}