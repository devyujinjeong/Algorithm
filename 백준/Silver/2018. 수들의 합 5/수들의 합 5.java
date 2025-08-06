import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 1; // 자기 자신 포함하기
        int s = 1;
        int e = 1;
        int sum = 1;

        while(e!=N) {
            if(sum < N) {
                e++;
                sum+=e;
            } else if(sum>N) {
                sum-=s;
                s++;
            } else {
                e++;
                sum+=e;
                answer++;
            }
        }

        System.out.println(answer);

    }
}