import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            String[] words = s.split(" ");

            Queue<String> q = new LinkedList<>();

            for(int j=0; j<words.length; j++) {
                q.add(words[j]);
            }

            while(!q.isEmpty()) {
                String word = q.poll();
                char[] alphabet = word.toCharArray();
                String newWord = "";
                for(int k = alphabet.length-1; k>=0; k--) {
                    newWord += alphabet[k];
                }
                sb.append(newWord).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}