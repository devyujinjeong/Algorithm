import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String vps = br.readLine();
            Stack<Character> ps = new Stack<Character>();
            
            boolean isVPS = true;
            for (int j = 0; j < vps.length(); j++) {
                if (vps.charAt(j) == '(') {
                    ps.push(vps.charAt(j));
                } else if (ps.isEmpty()) {
                    isVPS = false;
                    break;
                } else {
                    ps.pop();
                }
            }
            if (isVPS && ps.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}