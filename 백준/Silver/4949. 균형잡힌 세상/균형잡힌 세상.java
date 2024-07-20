import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        while (true) {
            String sen = br.readLine();
            if (sen.equals(".")) {break;}
            
            Stack<Character> bracket = new Stack<Character>();
            boolean check = true;
            
            for (int i = 0; i < sen.length(); i++) {
                char ch = sen.charAt(i);
                if (ch == '(' || ch == '[') {
                    bracket.push(ch);
                } else if (ch == ')') {
                    if (bracket.isEmpty() || bracket.peek() != '(') {
                        check = false;
                        break;
                    } else {
                        bracket.pop();
                    }
                } else if (ch == ']') {
                    if (bracket.isEmpty() || bracket.peek() != '[') {
                        check = false;
                        break;
                    } else {
                        bracket.pop();
                    }
                }
            }
            
            if (check && bracket.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}