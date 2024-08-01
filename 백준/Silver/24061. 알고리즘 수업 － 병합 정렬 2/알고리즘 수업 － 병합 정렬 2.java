import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] A, tmp;
    static int count, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1, bw); // 병합 정렬 실행하기

        if (count < K) {
            bw.write("-1\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int p, int r, BufferedWriter bw) throws IOException {
        if (count > K) {
            return;
        }

        int q;

        if (p < r) {
            q = (p + r) / 2;
            mergeSort(p, q, bw);
            mergeSort(q + 1, r, bw);
            merge(p, q, r, bw);
        }
    }

    private static void merge(int p, int q, int r, BufferedWriter bw) throws IOException {
        int t = 0; // tmp의 배열 번호
        int i = p;
        int j = q + 1;

        while (i <= q && j <= r) {
            if (A[i] >= A[j]) {
                tmp[t++] = A[j++];
            } else {
                tmp[t++] = A[i++];
            }
        }

        while (i <= q) {
            tmp[t++] = A[i++];
        }

        while (j <= r) {
            tmp[t++] = A[j++];
        }

        i = p;
        t = 0;

        while (i <= r) {
            count++;
            A[i++] = tmp[t++];
            if (count == K) {
                for (int k = 0; k < A.length; k++) {
                    bw.write(A[k] + " ");
                }
                bw.write("\n");
                break;
            }
        }
    }
}
