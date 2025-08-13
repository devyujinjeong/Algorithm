import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int count = 0;
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        calculate(4);
        calculate(7);

        System.out.println(count);
    }

    static void calculate(long a) {
        if(a>B) return; // B보다 a가 크다면 끝내기 (범위를 벗어남)
        if(A<=a) count++; // A가 a보다 작거나 같다면 count++;

        // 그 다음 값 계산하기
        // 4와 7로만 이루어진 수 이기 때문에 경우의 수는 다음과 같음
        calculate(10*a+4);
        calculate(10*a+7);
    }
}