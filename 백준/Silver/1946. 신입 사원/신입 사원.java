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
            int[] score = new int[N+1];
            int count = 0;

            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                int a =  Integer.parseInt(st.nextToken());
                int b =  Integer.parseInt(st.nextToken());
                score[a] = b;
            }

            int min = score[1];

            for(int j=1; j<N+1; j++) {
                if (min >= score[j]){
                    min = score[j];
                    count++;
                }
            }

            sb.append(count);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}