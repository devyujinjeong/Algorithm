import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, digit;
    static int answer = -1;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        num = new int[10];

        while(A>0) {
            num[A%10]++; // 해당 자리수의 개수 증가 (나머지가 2라면, 2의 개수 1개 증가)
            A/=10;
            digit++;
        }

        getNumber(0, 0);

        System.out.println(answer);

    }

    static void getNumber(int cur, int depth) {
        if(depth == digit) {
            if(cur < B) {
                answer = Math.max(answer, cur);
                return;
            }
        }

        for(int i=0; i<10; i++) {
            if(num[i] == 0 || i==0 && cur==0) continue; // 숫자를 사용할 수 없거나 첫번째 자리가 0인 경우는 제외

            num[i]--;
            getNumber(cur*10 + i,depth+1);
            num[i]++;
        }
    }
}