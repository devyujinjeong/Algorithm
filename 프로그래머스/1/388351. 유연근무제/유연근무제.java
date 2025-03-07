class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;

        for(int i=0; i<timelogs.length; i++){
            for(int j= 0; j<timelogs[i].length; j++){
                int tempDay = (j+startday)%7;
                if(tempDay==0||tempDay==6) continue;
                
                int realTime = (schedules[i]%100)>=50?schedules[i]+50:schedules[i]+10;
                                
                if(realTime<timelogs[i][j]){
                    answer--;
                    break;
                }
            }
        }        
        
        return answer;
    }
}