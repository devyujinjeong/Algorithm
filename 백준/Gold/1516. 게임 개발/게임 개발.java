import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] B;
    static int[] time;
    static int[] result;

    static int DFS(int i) {
        if (result[i] != 0) {
            return result[i];
        }

        int maxTime = 0;

        for (int j : B[i]) {
            maxTime = Math.max(maxTime, DFS(j));
        }

        result[i] = maxTime + time[i];
        return result[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        time = new int[N + 1];
        result = new int[N + 1];

        B = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            B[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int a = Integer.parseInt(st.nextToken());

                if (a == -1) {
                    break;
                }

                B[i].add(a);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(DFS(i));
        }
    }
}