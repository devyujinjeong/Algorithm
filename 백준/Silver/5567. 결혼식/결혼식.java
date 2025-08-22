import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] friend;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        friend = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            friend[i] = new ArrayList<>();
        }

        dist = new int[n+1];
        Arrays.fill(dist, -1);

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a].add(b);
            friend[b].add(a);
        }

        checkFriend(1);

        int count = 0;
        for(int i=2; i<=n; i++) {
            if(dist[i] == 1 || dist[i] == 2) count++;
        }

        System.out.println(count);
    }

    static void checkFriend(int s) {
        Queue<Integer> q = new LinkedList<>();
        dist[s] = 0;
        q.add(s);

        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int next : friend[temp]) {
                if(dist[next] != -1) continue; // -1이 아니라는 것은 이미 방문했다는 의미
                dist[next] = dist[temp] + 1;
                q.add(next);
            }
        }
    }
}