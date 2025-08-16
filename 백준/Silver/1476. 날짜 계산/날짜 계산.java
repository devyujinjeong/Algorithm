import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(E==15) E = 0;
        if(S==28) S = 0;
        if(M==19) M = 0;

        int N = 1;

        while (N % 15 != E || N % 28 != S || N % 19 != M) {
            N++;
        }

        System.out.println(N);

    }
}