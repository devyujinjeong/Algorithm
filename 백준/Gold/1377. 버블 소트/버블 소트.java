import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		numData[] a = new numData[N];
		
		for(int i=0; i<N; i++) {
			a[i] = new numData(Integer.parseInt(br.readLine()),i);
		}
		
		Arrays.sort(a);
		
		int max = 0;
		for(int i=0; i<N; i++) {
			if(max<a[i].index-i) {
				max = a[i].index - i;
			}
		}
		
		System.out.println(max+1);
			
	}
}

class numData implements Comparable<numData>{
	int value;
	int index;
	
	public numData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	
	@Override
	public int compareTo(numData o) {
		return this.value - o.value;
	}
}
