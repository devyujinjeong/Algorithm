import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int answer = 0;
        HashMap<Integer, Integer> num = new HashMap<>();

        int idx = 1;
        num.put(A, idx);

        while(true) {
            A = findNum(A, P);

            if(num.containsKey(A)) {
                answer = num.get(A) - 1;
                break;
            } else {
                num.put(A, ++idx);
            }
        }

        System.out.println(answer);

    }

    static int findNum(int num, int P) {
        int sum = 0;

        while(num>0) {
            sum += (int) Math.pow(num%10, P);
            num/=10;
        }

        return sum;
    }
}