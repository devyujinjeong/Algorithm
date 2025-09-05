import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        char[] digits = N.toCharArray();

        if (!N.contains("0")) { // 무조건 0으로 끝나야만 함
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (char d : digits) {
            sum += d - '0';
        }

        if (sum % 3 != 0) { // 자릿수를 더해서 3의 배수여야 함
            System.out.println(-1);
            return;
        }

        Arrays.sort(digits);
        for(char c : digits) {
           sb.append(c);
        }

        System.out.println(sb.reverse());
    }
}