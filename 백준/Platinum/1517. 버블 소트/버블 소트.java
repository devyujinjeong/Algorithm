import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] A, tmp;
	static long count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		A = new int[N+1];
		tmp = new int[N+1];
		count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // A배열에 데이터 저장
		}
		
		mergetSort(1,N); //병합 정렬 실행하기
		System.out.println(count);
	}
	
	// 병합 정렬 메소드                                                                                                                                                 
	private static void mergetSort(int s, int e) { // s: 시작점, e: 종료점, m: 중간 지점
		if (e - s < 1) {return;}
		int m = s + (e - s) / 2;

		// 병합한 그룹을 정렬 --> 다시 병합 --> 정렬 과정 반복을 위해 재귀함수 사용
		mergetSort(s, m);
		mergetSort(m + 1, e);

		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}

		// 두개의 그룹을 병합하기
		int k = s;
		int index1 = s; // set1의 index 시작점
		int index2 = m + 1; // set2의 index 시작점
		
		while (index1 <= m && index2 <= e) {
			// 각 set에서 index에 해당하는 값을 비교하기
			if (tmp[index1] > tmp[index2]) { // index1에 해당하는 값이 더 크다면 
				A[k] = tmp[index2]; // index2에 해당하는 값을 A배열에 저장하기
				count+=index2-k; // 개수 count하기
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		
		// 위의 반복문이 종료된 이후에 남아있는 데이터 정리하기
		while (index1 <= m) {
			A[k] = tmp[index1];		
			k++;
			index1++;
		}
		
		while (index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}