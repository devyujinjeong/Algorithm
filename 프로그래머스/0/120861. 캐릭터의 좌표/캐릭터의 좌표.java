class Solution {
    public int[] solution(String[] keyinput, int[] board) {  
        int[] answer = new int[2];
        
        int maxX = (board[0]-1)/2;
        int maxY = (board[1]-1)/2;
        
        for(int i=0; i<keyinput.length; i++) {
            // 현재 시점의 위치 저장하기
            int tempX = answer[0];
            int tempY = answer[1];
            
            // 위치 이동하기
            switch(keyinput[i]) {
                case "left":
                    answer[0]--;
                    break;
                case "right":
                    answer[0]++;
                    break;
                case "up":
                    answer[1]++;
                    break;
                case "down":
                    answer[1]--;
                    break;
            }
            
            // 위치가 맵의 크기를 초과하는 경우 이전 위치로 다시 변화시키기
            if(Math.abs(answer[0]) > maxX){
                answer[0] = tempX;
            }
            
            if(Math.abs(answer[1]) > maxY) {
                answer[1] = tempY;
            }
        }
            
        return answer;
    }
}