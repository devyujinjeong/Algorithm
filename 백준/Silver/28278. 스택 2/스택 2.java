import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int first = Integer.parseInt(st.nextToken());
                stack.add(first);
            } else if (a == 2) {
                int second = stack.isEmpty() ? -1 : stack.remove(stack.size() - 1);
                sb.append(second).append("\n");
            } else if (a == 3) {
                sb.append(stack.size()).append("\n");
            } else if (a == 4) {
                int fourth = stack.isEmpty() ? 1 : 0;
                sb.append(fourth).append("\n");
            } else if (a == 5) {
                int fifth = stack.isEmpty() ? -1 : stack.get(stack.size() - 1);
                sb.append(fifth).append("\n");
            }
        }

        System.out.print(sb.toString());
        br.close();
    }
}