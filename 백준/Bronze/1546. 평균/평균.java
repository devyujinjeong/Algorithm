import java.util.Arrays;
import java.util.Scanner;
	
	public class Main {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			float[] allScore = new float[N];
			
			for(int i=0; i<N; i++) {
				allScore[i] = sc.nextInt();
			}
			
			float max=allScore[0];
			float sum = 0;
			
			for(int i=0; i<N; i++) {
				if(max<allScore[i]) {
					max=allScore[i];
				}
				sum+=allScore[i];
			}		
			System.out.println(sum/max*100/allScore.length);
		}
	}