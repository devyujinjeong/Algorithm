import java.util.*;

class Solution {    
    public int[] solution(int n) {
        HashSet<Integer> divisor = new HashSet<Integer>();

       	for(int i=2; i<=n; i++) {
            if(n%i==0){
                while(n%i==0){
                    divisor.add(i);
                    n/=i;
                }
                
            }
        }
        
        int[] answer = new int[divisor.size()];
        int i = 0;
        for(int num:divisor){
            answer[i++] = num;
        }
        Arrays.sort(answer);

        return answer;

    }
}
