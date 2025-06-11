import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static HashMap<Integer, Integer> hm;
    static ArrayList<Integer> num;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hm = new HashMap<>();
        num = new ArrayList<>();
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int K = Integer.parseInt(st.nextToken());
            hm.put(K, hm.getOrDefault(K, 0) + 1);
        }

        num.addAll(hm.keySet());

        Collections.sort(num);

        backtracking(0, new StringBuilder());

        System.out.println(sb);
    }

    static void backtracking(int depth, StringBuilder cur) {
        if(depth == M) {
            sb.append(cur).append("\n");
            return;
        }

        for(int i : num) {
            if(hm.get(i) > 0) {
                int len = cur.length();
                hm.put(i, hm.get(i) - 1);
                cur.append(i).append(" ");
                backtracking(depth+1, cur);
                cur.setLength(len);
                hm.put(i, hm.get(i) + 1);
            }
        }
    }
}
