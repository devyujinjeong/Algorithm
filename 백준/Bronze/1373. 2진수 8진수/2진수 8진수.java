import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String b = br.readLine().trim();

        if (b.equals("0")) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int len = b.length();

        for (int i = len; i > 0; i -= 3) {
            int sum = 0;
            int base = 1;           
            for (int j = i - 1; j >= Math.max(0, i - 3); j--) {
                sum += (b.charAt(j) - '0') * base;
                base <<= 1;        
            }
            sb.append(sum);          
        }

        System.out.println(sb.reverse().toString());
    }
}
