import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : s.toCharArray()) {
            left.push(c);
        }

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String e = st.nextToken();

            if(e.equals("P")) {
                char ch = st.nextToken().charAt(0);
                left.push(ch);
            } else if(e.equals("L") && !left.empty()) {
                right.push(left.pop());
            } else if(e.equals("D") && !right.empty()) {
                left.push(right.pop());
            } else if(e.equals("B") && !left.empty()) {
                left.pop();
            }
        }


        while (!left.isEmpty()) {
            sb.append(left.pop());
        }
        sb.reverse();

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
