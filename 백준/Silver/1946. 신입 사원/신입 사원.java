import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine()); // 지원자 수
            int[][] score = new int[N][2];
            int count = 0;

            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                score[j][0] = Integer.parseInt(st.nextToken()); // 1차 시험 점수
                score[j][1] = Integer.parseInt(st.nextToken()); // 2차 시험 점수
            }

            Arrays.sort(score,(o1,o2) -> (o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]));

            int min = score[0][1];

            for(int j=0; j<N; j++) {
                if (min >= score[j][1]){
                    min = score[j][1];
                    count++;
                }
            }

            sb.append(count);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}