import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // <> : 이 괄호에 감싸있으면 단어가 아님
        // '<'를 만나면 쭉 q에 넣다가 '>'를 만나면 끝!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        // 똑바로 넣을지? 아니면 스택에 넣어서 출력할지?

        int i = 0;
        while(i<s.length()) {
            if(s.charAt(i) == '<') {
                while(true) {
                    sb.append(s.charAt(i++));
                    if(s.charAt(i) == '>') {
                        sb.append(s.charAt(i++));
                        break;
                    }
                }
            } else if(s.charAt(i) == ' ') {
                sb.append(s.charAt(i++));
            } else {
                while(i<s.length() && s.charAt(i)!= '<'&& s.charAt(i) != ' ') {
                    stack.add(s.charAt(i++));
                }

                while(!stack.empty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb);
    }
}
