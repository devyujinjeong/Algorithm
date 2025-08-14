import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int A,B;
    static ArrayList<Integer> nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        nums = new ArrayList<>();

        while(A>0) {
            nums.add(A%10);
            A/=10;
        }

        visited = new boolean[nums.size()];

        System.out.println(getNumber(0,0,nums.size()));
    }

    static int getNumber(int cur, int depth, int digit) {
        if (depth == digit) {
            if (cur < B) { // 완성된 수가 B보다 작은 경우만
                return cur;
            }
            return -1;
        }

        int maxValue = -1; // 가능한 최대값 추적

        for (int i = 0; i < nums.size(); i++) {
            if (!visited[i]) {
                if (depth == 0 && nums.get(i) == 0) continue; // 맨 앞 0 제외

                visited[i] = true;
                int result = getNumber(cur * 10 + nums.get(i), depth + 1, digit);
                visited[i] = false;

                if (result > maxValue) {
                    maxValue = result;
                }
            }
        }

        return maxValue;
    }
}
