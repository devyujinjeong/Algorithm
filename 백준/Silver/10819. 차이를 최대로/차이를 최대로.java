import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N; // 숫자의 개수
    static int[] num; // 숫자를 저장하는 배열
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        findNumber(0,0, 0);
        System.out.println(max);
    }

    static void findNumber(int depth, int cur, int temp) {
        if(depth == N) {
            if(max < cur){
                max = cur;
            }
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;

                if(depth >= 1) {
                    findNumber(depth+1, cur + Math.abs(temp - num[i]), num[i]);
                } else {
                    findNumber(depth+1, 0, num[i]);
                }

                visited[i] = false;
            }
        }

    }
}