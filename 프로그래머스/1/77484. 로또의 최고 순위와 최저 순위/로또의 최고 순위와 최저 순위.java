import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] ranking = {6,6,5,4,3,2,1};
        
        // 일치하는 로또 번호가 몇 개 있는지 확인하기
        int check = 0;
        // 0인 번호가 몇 개 있는지 확인하기
        int zero = 0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);


        
        
        int j = 0;
        for(int i=0; i<6; i++){
            if(lottos[i]==0){
                zero++;      
            }else{
                while(j!=6&&win_nums[j]<=lottos[i]){
                    if(lottos[i] == win_nums[j]){
                        check++; 
                        j++;
                        break;
                    }else{
                        j++;
                    }
                }
            }
        }
        
        answer[0] = ranking[check+zero];
        answer[1] =  ranking[check];
        
        
        
        return answer;
    }
}