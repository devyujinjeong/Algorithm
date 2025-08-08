import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder();
            String s = br.readLine();
            String[] words = s.split(" ");

            for(String word : words) {
                StringBuilder tempW = new StringBuilder(word);
                sb.append(tempW.reverse()).append(" ");
            }

            System.out.print(sb);
        }
    }
}