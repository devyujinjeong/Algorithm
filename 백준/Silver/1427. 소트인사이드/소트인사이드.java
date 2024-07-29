import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		ArrayList<Character> numData = new ArrayList<Character>(N.length());
		
		for(int i=0; i<N.length(); i++) {
			numData.add(N.charAt(i));
		}

		numData.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);
	}
}
	