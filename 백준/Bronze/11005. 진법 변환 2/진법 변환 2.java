import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int digit = 0;
        int temp = a;

        while(temp!=0) {
            temp/=b;
            digit++;
        }

        for(int i=digit-1; i>=0; i--) {
            int num = (int)Math.pow(b,i);
            int k = a/num;

            if(k>=10) {
                sb.append((char)(k+55));
            } else {
                sb.append(k);
            }

            a -= num * k;
        }

        System.out.println(sb);

    }
}
