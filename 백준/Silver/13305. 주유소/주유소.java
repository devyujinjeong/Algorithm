import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Integer> length = new ArrayList<Integer>();
		ArrayList<Integer> money = new ArrayList<Integer>();		
		
		for (int i=0; i<n-1; i++) {length.add(sc.nextInt());} // 도시 사이의 거리
		
		for (int i=0; i<n; i++) {money.add(sc.nextInt());} // 기름값
		
		int total = length.get(0)*money.get(0);
		
		for (int i=1; i<n-1; i++) {
			if(money.get(i-1)<money.get(i)) {
				total+=money.get(i-1)*length.get(i);
			}else {
				total+=money.get(i)*length.get(i);
			}
		}
		
		System.out.println(total);
		
	}
	
}
