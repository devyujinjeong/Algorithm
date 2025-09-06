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

        int[][] tr = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                tr[i][j] = s.charAt(j) -'0';
            }
        }

        int min = Math.min(N,M);

        for(int len = min; len>=2; len--) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {

                        if(i+len-1>=N || j+len-1>=M) continue; // 범위를 초과하는 경우

                        if(tr[i][j]==tr[i+len-1][j] && tr[i+len-1][j]==tr[i][j+len-1]&&tr[i][j+len-1]==tr[i+len-1][j+len-1]) {
                            System.out.println(len*len);
                            return;
                        }
                    }
                }
        }

        System.out.println(1);
    }
}