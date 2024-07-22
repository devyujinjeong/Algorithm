import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int count = 0;
		
		HashSet<Integer> setA = new HashSet<Integer>();
		HashSet<Integer> setB = new HashSet<Integer>();
				
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i:setA) {
			if(setB.contains(i)) {
				count++;
			}
		}
			System.out.println(a+b-2*count);
	}
}