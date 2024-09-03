import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class lEdge implements Comparable<lEdge> {
    int s;
    int e;
    int v;

    public lEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(lEdge l) {
        return this.v - l.v;
    }
}

public class Main {
    static int[] uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int total = 0;

        uf = new int[N];
        PriorityQueue<lEdge> pq = new PriorityQueue<lEdge>();

        for (int i = 0; i < N; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for (int j = 0; j < N; j++) {
                char c = a.charAt(j);
                int r = 0;
                if (c != '0') {
                    if (c >= 'a' && c <= 'z') {
                        r = c - 'a' + 1;
                    } else if (c >= 'A' && c <= 'Z') {
                        r = c - 'A' + 27;
                    }
                    if (i != j) {
                        pq.add(new lEdge(i, j, r));
                    }
                    total += r;
                }
            }
        }

        int sum = 0;
        int numEdge = 0;

        while (!pq.isEmpty() && numEdge < N - 1) {
            lEdge l = pq.poll();
            int s = l.s;
            int e = l.e;

            if (find(s) != find(e)) {
                union(s, e);
                sum += l.v;
                numEdge++;
            }
        }

        if (numEdge < N - 1) {
            System.out.println(-1);
        } else {
            System.out.println(total - sum);
        }
    }

    static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            uf[j] = i;
        }
    }

    static int find(int k) {
        if (k == uf[k]) {
            return k;
        } else {
            return uf[k] = find(uf[k]);
        }
    }
}
