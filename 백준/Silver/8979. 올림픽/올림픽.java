import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] medal = new int[N][4];
        int[] result = new int[N+1];

        // 메달 저장하기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); // 나라 번호
            int gold = Integer.parseInt(st.nextToken()); // 금메달 수
            int silver = Integer.parseInt(st.nextToken()); // 은메달 수
            int bronze = Integer.parseInt(st.nextToken()); // 동메달 수

            medal[i][0] = c;
            medal[i][1] = gold;
            medal[i][2] = silver;
            medal[i][3] = bronze;
        }

        Arrays.sort(medal, (o1, o2) ->
                o1[1] != o2[1] ? o2[1] - o1[1] :
                        o1[2] != o2[2] ? o2[2] - o1[2] :
                                o1[3] != o2[3] ? o2[3] - o1[3] : o1[3] - o2[3]);


        int count = 1;
        result[medal[0][0]] = 1;
        for(int i=1; i<N; i++) {
            count++;

            if(medal[i][1] == medal[i-1][1] && medal[i][2] == medal[i-1][2] && medal[i][3] == medal[i-1][3]) {
                result[medal[i][0]] = result[medal[i-1][0]];
            } else {
                result[medal[i][0]] = count;
            }

        }

        System.out.println(result[K]);

    }
}