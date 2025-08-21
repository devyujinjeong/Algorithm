import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] array = new int[N+1];
            boolean[] visited = new boolean[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for(int k=1; k<=N; k++) {
                if(!visited[k]) {
                    int temp = k;
                    while (!visited[temp]) {
                        visited[temp] = true;
                        temp = array[temp];
                    }
                    count++;
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);
    }
}