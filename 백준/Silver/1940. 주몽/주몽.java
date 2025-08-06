import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int count = 0;

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i <N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // 1. 정렬하기

        int s = 0;
        int e = N-1;
        while(s<e) {
            if (num[s] + num[e] < M) { // M보다 작은 경우
                s++;
            } else if (num[s] + num[e] > M) {// M보다 큰 경우
                e--;
            } else {
                s++;
                e--;
                count++;
            }
        }

        System.out.println(count);
    }
}