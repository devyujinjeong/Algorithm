import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] num;
    static int[] rank;

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            if (rank[a] > rank[b]) {
                num[b] = a;
            } else {
                num[a] = b;
                if (rank[a] == rank[b]) {
                    rank[b]++;
                }
            }
        }
    }

    static int find(int a) {
        if (num[a] != a) {
            num[a] = find(num[a]);
        }
        return num[a];
    }
    
    static void checkSamePnode(int a, int b) throws IOException {        
        if (find(a) == find(b)) {
            sb.append("YES").append('\n');
        } else {
            sb.append("NO").append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        num = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            num[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (w == 0) {
                union(a, b);
            } else {
                checkSamePnode(a, b);
            }
        }
        
        System.out.println(sb.toString());
    }
}