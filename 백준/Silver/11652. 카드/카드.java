import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] card = new long[N];

        for(int i=0; i<N; i++) {
            card[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(card);

        long mostCard = card[0];
        int maxCount = 1;
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (card[i] == card[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxCount) {
                maxCount = count;
                mostCard = card[i];
            }
        }

        System.out.println(mostCard);
    }
}