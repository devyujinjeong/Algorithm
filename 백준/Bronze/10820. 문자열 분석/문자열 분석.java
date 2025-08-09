import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int lower = 0, upper = 0, digit = 0, space = 0;
            for (char ch : line.toCharArray()) {
                if (Character.isLowerCase(ch)) lower++;
                else if (Character.isUpperCase(ch)) upper++;
                else if (Character.isDigit(ch)) digit++;
                else if (ch == ' ') space++;
            }
            System.out.printf("%d %d %d %d\n", lower, upper, digit, space);
        }
    }
}
