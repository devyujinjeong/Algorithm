class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int n = sequence.length;
        
        int s = 0; // 시작 인덱스
        int e = 0; // 종료 인덱스
        
        int len = Integer.MAX_VALUE; // 수열의 길이
        int sum = sequence[0]; // 부분 수열의 합
        
        while(s<n && e<n) {     
            if(sum==k) {
                if(len>e-s) { // 수열의 길이가 len보다 작으면 업데이트
                    answer[0] = s;
                    answer[1] = e;
                    len = e-s;
                }
            } 
            
            if(sum>k) { // 합이 k보다 큰 경우
                if(s<n) {
                    sum-=sequence[s];
                }
                s++;
            } else { // 합이 k보다 작은 경우
                e++;
                if(e<n) {
                    sum+=sequence[e];   
                }
            }
        }
        
        return answer;
    }
}