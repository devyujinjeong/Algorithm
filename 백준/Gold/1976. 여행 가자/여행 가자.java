import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] city;
    
    static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            city[j] = i;
        }
    }

    static int find(int a) {
        if (city[a] != a) {
            city[a] = find(city[a]);
        }
        return city[a];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean going = true;
                
        int[][] relation = new int[N + 1][N + 1];
        int[] trip = new int[M];
        city = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            city[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                relation[i][j] = Integer.parseInt(st.nextToken());
                if (relation[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            trip[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M - 1; i++) {
            if (find(trip[i]) != find(trip[i + 1])) {
                going = false;
                break;
            }
        }

        if (going) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}