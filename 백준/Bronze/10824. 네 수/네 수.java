import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String ab = "";
        String cd = "";

        for(int i=0; i<4; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if(i<2) {
                ab+=num;
            } else {
                cd+=num;
            }
        }

        System.out.println(Long.parseLong(ab) + Long.parseLong(cd));
    }
}
