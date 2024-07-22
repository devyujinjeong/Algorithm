import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count =0;
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			ArrayList<Character> wordChar = new ArrayList<Character>();
			char now = word.charAt(0);
			wordChar.add(now);
			
			for (int j = 1; j < word.length(); j++) {
				if(word.charAt(j)!=now&&wordChar.contains(word.charAt(j))) {
					break;
				}else {
					wordChar.add(word.charAt(j));
					now = word.charAt(j);					
				}
			}
			
			if(word.length()==wordChar.size()) {
				count++;
			}
		}
		System.out.println(count);
	}
}