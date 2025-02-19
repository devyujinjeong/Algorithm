import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < b; i++) {
            String person = br.readLine();
            if (set.contains(person)) {
                result.add(person);
            }
        }

        Collections.sort(result);

        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }

        System.out.print(sb);
    }
}
