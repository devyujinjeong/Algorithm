import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String cal = br.readLine();
		String[] str = cal.split("\\-"); // -를 기준으로 문자 자르기
		
		for(int i=0 ;i<str.length; i++) {
			if(str[i].contains("+")) {
				String[] plus = str[i].split("\\+");
				int num = 0;
				for(int j=0; j<plus.length; j++) {
					num+=Integer.parseInt(plus[j]);
				}
				str[i] = Integer.toString(num);
			}
		}
		
		int result = Integer.parseInt(str[0]);
		for(int i=1; i<str.length; i++) {
			result -= Integer.parseInt(str[i]);
		}
		
		System.out.println(result);
	}
}