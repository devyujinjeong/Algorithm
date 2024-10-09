import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<Character> word;
	static long[][] D;
	static char[] a;
	static char[] b;
	
	static void getLCS(int i, int j) {
		if(i==0||j==0) {return;}
		
		if(a[i-1]==b[j-1]) {
			word.add(a[i-1]);
			getLCS(i-1, j-1);
		}else {
			if(D[i-1][j]>D[i][j-1]) {
				getLCS(i-1,j);
			}else {
				getLCS(i,j-1);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		a = str1.toCharArray();
		b = str2.toCharArray();
		
		int length1 = str1.length();
		int length2 = str2.length();
		
		D = new long[length1+1][length2+1];
		word = new ArrayList<Character>();
		
		for(int i=1; i<=length1; i++) {
			for(int j=1; j<=length2; j++) {
				if(a[i-1]==b[j-1]) {
					D[i][j] = D[i-1][j-1]+1;
				}else {
					D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
				}
			}
		}
		
		System.out.println(D[length1][length2]);
		
		getLCS(length1, length2);
		for(int i=word.size()-1; i>=0; i--) {
			sb.append(word.get(i));
		}
		
		System.out.println(sb);
	}
} 