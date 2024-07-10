import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = 0; 
		String num = sc.next();
		
		// N이라는 숫자를 입력하는 순간 크기가 정해지기 때문에, 배열 사용
		char[] numSplit = new char[N];
		
		for(int i=0; i<N; i++) {
			numSplit[i] = num.charAt(i);
			sum += Character.getNumericValue(numSplit[i]);
		}		
		System.out.println(sum);
	}
}