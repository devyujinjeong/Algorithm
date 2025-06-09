import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] sign, num;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        sign = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자 저장하기
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        // 기호 저장하기
        for(int i=0; i<4; i++) {
            sign[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹을 이용해 연산 하는 것 가져오기
        backtracking(1, num[0]);

        System.out.println(max);
        System.out.println(min);

    }

    static void backtracking(int depth, int result){
        if(depth == N){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        // sign을 방문 배열처럼 사용하기
        // 기호가 총 4개이기 때문에 4번만 반복하기
        for(int i=0; i<4; i++) {
            // 만약에 0이 아니라면 cur에 추가하기
            if(sign[i] > 0) {
                sign[i]--;
                int next = calculate(result, num[depth], i);
                backtracking(depth+1, next);
                sign[i]++;
            }
        }
    }


    // 계산 하기 위한 함수
    static int calculate(int a, int b, int op){
        switch(op){
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            case 3: return a / b; // 문제 조건: 음수 나눗셈도 자바 기본 방식 사용
        }
        return 0;
    }
}
