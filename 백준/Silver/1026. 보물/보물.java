import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        for(int i=0; i<2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                if(i==0) {
                    A[j] = Integer.parseInt(st.nextToken());
                } else {
                    B[j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for(int i=0; i<N; i++) {
            answer += A[i] * B[N-i-1];
        }

        System.out.println(answer);
    }
}