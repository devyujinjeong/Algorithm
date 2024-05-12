import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Long[] length = new Long[N-1]; 
		Long[] oil = new Long[N];
		
		for (int i=0; i<N-1; i++) {length[i]=sc.nextLong();} // 도시 사이의 거리
		
		for (int i=0; i<N; i++) {oil[i]=sc.nextLong();} // 기름값 (1L당 금액)
		
		Long total = length[0]*oil[0]; // 가장 처음에는 다음 도시까지 갈 기름은 충전해야 함
		Long min = oil[0];
		
		for (int i=1; i<N-1; i++) {
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
