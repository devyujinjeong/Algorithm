import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] twoDim1 = new int[N][2];	
		
		for(int i=0; i<N ; i++) {
			twoDim1[i][0] = sc.nextInt();
			twoDim1[i][1] = sc.nextInt();
		}
			
		Arrays.sort(twoDim1, new Comparator<int[]>() { 
		    @Override
		    public int compare(int[] x, int[] y) {
		        return x[1]!=y[1] ? x[1]-y[1] : x[0]-y[0]; 
		    }
		});	
		
		for(int j=0; j<N; j++) {
			System.out.println(twoDim1[j][0]+" "+twoDim1[j][1]);
		}	
	}
}
	
	