import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();

		a = a.replaceAll(b, "0");
		int result = 0;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '0') {
				result++;
			}
		}
		
		System.out.println(result);
	}
}