import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int min = N+1;
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0, sum = 0;

        // 정렬된 상태가 아니고, 숫자가 몇인지 모르기 때문에
        while(e <= N) {
            if(sum >= S) {
                min = Math.min(min, e-s);
                sum-=num[s++];
            } else {
                if(e==N) break;
                sum+=num[e++];
            }
        }

        System.out.println(min == N+1? 0 : min);

    }
}
