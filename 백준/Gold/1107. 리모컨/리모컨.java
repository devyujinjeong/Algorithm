import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int N, digit;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[10];

        if(M>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                visited[Integer.parseInt(st.nextToken())] = true; // 사용할 수 없는 것들은 true로 처리
            }
        }

        // 자릿수 구하기
        int tempN = N;

        while (tempN > 0) {
            tempN /= 10;
            digit++;
        }

        answer = Math.abs(N - 100); // 그냥 버튼만 눌러서 이동하는 경우

        // 최대 6자리까지니깐 자릿수에 맞게 탐색
        for (int len = 1; len <= 6; len++) {
            findChannel(0, 0, len);
        }

        System.out.println(answer);
    }

    static void findChannel(int cur, int depth, int tempLen) {
        if(depth == tempLen) {
            int result = tempLen + Math.abs(N-cur);
            answer = Math.min(answer, result);
            return;
        }

        for(int i=0; i<10; i++) {
            if(visited[i]) continue;

            if(depth == 0 && i == 0 && tempLen > 1) continue;

            findChannel(cur*10+i, depth+1, tempLen);
        }
    }
}