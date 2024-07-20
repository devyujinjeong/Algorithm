import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        String bar = br.readLine();
        int totalPieces = 0; 
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < bar.length(); i++) {
            char current = bar.charAt(i);
            if (current == '(') {
                stack.push(current);
            } else {
                stack.pop();
                if (bar.charAt(i - 1) == '(') { // 레이저인 경우
                    totalPieces += stack.size();
                } else { // 철막대인 경우
                    totalPieces++;
                }
            }
        }

        System.out.println(totalPieces);
    }
}