import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        // 1. 소문자 (65 ~ 90)
        // 2. 대문자 (97 ~ 122)

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(65<=c && c<=90) {
                if(c<=77) {
                    c+= 13;
                } else {
                    c-=13;
                }
            } else if(97<=c && c<=122) {
                if(c<=109) {
                    c+= 13;
                } else {
                    c-=13;
                }
            }

            sb.append(c);
        }

        System.out.println(sb);
    }
}
