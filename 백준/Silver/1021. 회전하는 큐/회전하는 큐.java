import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        LinkedList<Integer> dq = new LinkedList<>();

        for(int i=0; i<N; i++) {
            dq.add(i+1);
        }
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            int want = Integer.parseInt(st.nextToken());

            int idx = dq.indexOf(want);
            int size = dq.size();

            if(idx<=size/2) {
                // 오른쪽으로 회전
                for (int k = 0; k < idx; k++) {
                    dq.addLast(dq.removeFirst());
                    count++;
                }
            } else {
                // 왼쪽으로 회전
                for (int k = 0; k < size - idx; k++) {
                    dq.addFirst(dq.removeLast());
                    count++;
                }
            }

            dq.removeFirst();
        }

        System.out.println(count);
    }
}
