import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        String a = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int digit = a.length();

        for(int i=0; i<digit; i++) {
            int temp = (int)Math.pow(b,i);
            int num = a.charAt(digit-i-1);
            if(num >= 65) { // 알파벳인 경우
                result += temp * (num-55);
            } else { // 숫자인 경우
                String v = String.valueOf(a.charAt(digit-i-1));
                result += temp * Integer.parseInt(v);
            }
        }

        System.out.println(result);
    }
}