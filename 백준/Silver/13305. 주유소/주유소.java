import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] length = new int[n-1]; 
		int[] oil = new int[n];
		
		for (int i=0; i<n-1; i++) {length[i]=sc.nextInt();} // 도시 사이의 거리
		
		for (int i=0; i<n; i++) {oil[i]=sc.nextInt();} // 기름값 (1L당 금액)
		
		int total = length[0]*oil[0]; // 가장 처음에는 다음 도시까지 갈 기름은 충전해야 함
		int min = oil[0];
		
		for (int i=1; i<n-1; i++) {
			if(min<oil[i]) { // 전 도시의 기름값이 더 저렴할 경우
				total+=min*length[i]; 
			}else {
				min = oil[i];
				total+=min*length[i];
			}
		}
		
		System.out.println(total);
		
	}
	
}
