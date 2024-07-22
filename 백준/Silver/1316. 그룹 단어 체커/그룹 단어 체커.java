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
			char first = word.charAt(0);
			wordChar.add(first);
			
			for (int j = 1; j < word.length(); j++) {
				if (word.charAt(j) == first) {
					wordChar.add(word.charAt(j));
					first = word.charAt(j);
				} else {
					if (wordChar.contains(word.charAt(j))) { // 알파벳이 전과 다른데, 알파벳을 wordChar에서 포함하고 있는 경우
						break;
					} else {
						wordChar.add(word.charAt(j));
						first = word.charAt(j);
					}
				}
			}
			
			if(word.length()==wordChar.size()) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}