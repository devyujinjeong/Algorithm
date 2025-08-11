import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String answer = "YES";
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == '(') {
                    stack.add('(');
                } else if(s.charAt(j) == ')' && !stack.isEmpty()){
                    stack.pop();
                } else {
                    answer = "NO";
                }
            }

            if(!stack.isEmpty()) answer = "NO";

            System.out.println(answer);
        }
    }
}