import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		int N = num.length();
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] =  Character.getNumericValue(num.charAt(i));
		}
		
		for(int i=0; i<N; i++) {
			int max = i;
			for(int j=i+1; j<N; j++) {
				if(A[max]<A[j]) {
					max = j;
				}				
			}

			if(A[i]<A[max]) {
				int a = A[i];
				A[i] = A[max];
				A[max] = a;
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(A[i]);
		}
	}

}
