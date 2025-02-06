import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        // 1. 돈을 적게 신청한 부서부터 돈을 지원해주기
        // 2. 정렬을 이용해 신청 금액을 정렬
        // 3. 전체 예산에서 신청 금액을 빼면서 count 진행하기
        
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++){
            if(budget-d[i]>=0){
                answer++;
                budget-=d[i];
            }
        }
        
        
        return answer;
    }
}