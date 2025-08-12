import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(true) {
            int q = N/-2;
            int r = N%-2;

            if(r==-1) {
                r+=2;
                q+=1;
            }

            sb.append(Math.abs(r));

            if(q==0) break;

            N = q;
        }

        System.out.println(sb.reverse());
    }
}