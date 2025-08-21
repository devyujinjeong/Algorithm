import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] kinship;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        kinship = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            kinship[i] = new ArrayList<>();
        }

        dist = new int[n+1];
        Arrays.fill(dist, -1);

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            kinship[x].add(y);
            kinship[y].add(x);
        }

        System.out.println(findRelation(a, b));

    }

    static int findRelation(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;

        while(!q.isEmpty()) {
            int temp = q.poll();

            if(temp == y) return dist[temp];

            for(int p : kinship[temp]) {
                if(dist[p] != -1) continue;
                dist[p] = dist[temp] + 1;
                q.add(p);
            }
        }

        return -1;
    }
}