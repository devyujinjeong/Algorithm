import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count =0;
		
		for (int i = 0; i < N; i++) {
			String word = sc.next();
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