import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus> {
	int city;
	int price;

	public Bus(int city, int price) {
		this.city = city;
		this.price = price;
	}

	@Override
	public int compareTo(Bus bus) {
		return Integer.compare(this.price, bus.price);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수
		int[] total = new int[N + 1]; // 총 가격 저장을 위한 배열
		boolean[] visited = new boolean[N + 1]; // 방문 배열
		PriorityQueue<Bus> q = new PriorityQueue<Bus>();
		ArrayList<Bus>[] B = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			B[i] = new ArrayList<Bus>();
		}

		for (int i = 0; i <= N; i++) {
			total[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			B[s].add(new Bus(e, p));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		q.add(new Bus(start, 0));
		total[start] = 0;
		
		while(!q.isEmpty()) {
			Bus sCity = q.poll();
			int num = sCity.city;
			
			if(visited[num]) {continue;}
			visited[num] = true;
			
			for(int i=0; i<B[num].size(); i++) {
				Bus cur = B[num].get(i);
				int curNum = cur.city;
				int curPrice = cur.price;
				
				int money = total[num] + curPrice;
				if(total[curNum]>money) {
					total[curNum] = money;
					q.add(new Bus(curNum,total[curNum]));
				}
			}
		}	
		System.out.println(total[end]);
	}
}