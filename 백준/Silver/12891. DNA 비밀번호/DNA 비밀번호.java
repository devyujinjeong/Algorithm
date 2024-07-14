import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] countC;
    static int[] checkC;
    static int num = 0;
    static char[] listDNA = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        String A = br.readLine();

        countC = new int[4];
        checkC = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            countC[i] = Integer.parseInt(st.nextToken());
            if (countC[i] == 0) {
                num++;
            }
        }

        char[] cList = A.toCharArray(); // 문자열을 문자 배열로 변환

        for (int i = 0; i < P; i++) {
            Add(cList[i]);
        }

        if (num == 4) {
            result++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(cList[i]);
            Delete(cList[j]);
            if (num == 4) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void Add(char c) {
        for (int i = 0; i < 4; i++) {
            if (c == listDNA[i]) {
                checkC[i]++;
                if (checkC[i] == countC[i]) {
                    num++;
                }
            }
        }
    }

    private static void Delete(char c) {
        for (int i = 0; i < 4; i++) {
            if (c == listDNA[i]) {
                if (checkC[i] == countC[i]) {
                    num--;
                }
                checkC[i]--;
            }
        }
    }
}
