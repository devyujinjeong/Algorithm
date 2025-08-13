import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int min = Math.min(N,M);
        int max = 1;

        int[][] tr = new int[N][M];

        /* 1. 직사각형 만들기  */
        for(int i=0; i<N; i++) {
            String num = br.readLine();
            for(int j=0; j<M; j++) {
                tr[i][j] = num.charAt(j) - '0';
            }
        }

        /* 2. 크기가 큰 정사각형 부터 계산하기 */
        for(int i= min-1; i>=1; i--) {
            for(int j=0; i+j<N; j++) {
                for(int k=0; k+i<M; k++) {
                    int idx1 = j+i;
                    int idx2 = k+i;
                    if(tr[j][k] == tr[j][idx2] && tr[j][idx2] == tr[idx1][k] && tr[idx1][k] == tr[idx1][idx2]) {
                        max = i+1;
                        System.out.println(max * max);
                        return;
                    }
                }
            }
        }

        System.out.println(max);

    }
}
