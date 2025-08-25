import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        tree = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                count++;
                findConnection(i);
            }
        }

        System.out.println(count);
    }

    static void findConnection(int s) {
        if(visited[s]) return;

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();

            for(int next : tree[temp]) {
                if(visited[next]) continue;

                q.add(next);
                visited[next] = true;
            }
        }
    }
}