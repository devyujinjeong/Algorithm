import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A, tmp;
    static int count, result ,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        K = Integer.parseInt(st.nextToken()); // 저장 횟수

        A = new int[N + 1];
        tmp = new int[N + 1];
        result = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // A배열에 데이터 저장
        }

        mergeSort(1, N); // 병합 정렬 실행하기
        System.out.println(result);
    }

    private static void mergeSort(int p, int r) {
        if (count>K) {return;}

        int q;
        
        if(p<r) {
        	q = (p+r)/2;
        	mergeSort(p, q);
        	mergeSort(q + 1, r);
        	merge(p, q, r);
        }

    }

    private static void merge(int p, int q, int r) {
        int t = 1; // tmp의 배열 번호
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
        
        i=p;
        t=1;
        
        while(i<=r) {
        	count++;
        	if(count==K) {
        		result = tmp[t];
        		break;
        	}
        	A[i++] = tmp[t++];
        }
    }
}
