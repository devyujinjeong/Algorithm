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
        int max = 0, min = 0;

        int[] money = new int[N];

        for(int i=0; i<N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max += money[i]; // 모든 돈을 더한 경우가 인출 금액의 최대값
            min = Math.max(min, money[i]); // 사용 한 금액 중 가장 큰 금액이 최소값
        }


        while(min < max) {
            int cnt = 1;
            int mid = (max + min) / 2; // 중간 비용
            int temp = mid;

            // 만약 성공이면 돈을 줄이고, 실패면 돈을 늘리기
            for (int i = 0; i < N; i++) {
                if (temp < money[i]) {
                    temp = mid;
                    cnt++;
                }
                temp -= money[i];
            }

            if(cnt<=M) { 
                max = mid; // 돈을 줄이기
            } else{ 
                min = mid + 1; // 돈을 늘리기
            }
        }

        System.out.println(min);
    }
}