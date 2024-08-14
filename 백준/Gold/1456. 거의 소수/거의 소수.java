import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Long> prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        prime = new ArrayList<>();

        findPrime((long)Math.sqrt(B));
        checkPrimeByB(A, B);
    }

    static void findPrime(long limit) {
        boolean[] isPrime = new boolean[(int)limit + 1];
        
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                prime.add((long)i);
            }
        }
    }

    static void checkPrimeByB(long A, long B) {
        int count = 0;

        for (long p : prime) {
            long power = p * p;  // p^2 부터 시작
            while (power <= B) {
                if (power >= A) {
                    count++;
                }
                if (power > B / p) {  // overflow 방지
                    break;
                }
                power *= p;
            }
        }

        System.out.println(count);
    }
}
