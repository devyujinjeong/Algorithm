import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int[] alphabet = new int[26];

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            for(int j=97; j<123; j++) {
                if(c == j) {
                    alphabet[j-97]++;
                }
            }
        }

        for (int i=0; i<26; i++) {
            System.out.print(alphabet[i] + " ");
        }

    }
}