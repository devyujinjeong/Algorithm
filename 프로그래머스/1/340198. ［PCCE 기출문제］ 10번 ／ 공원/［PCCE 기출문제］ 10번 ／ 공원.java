import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        // 가장 큰 돗자리부터 비교하기 위해서, 정렬하기
        Arrays.sort(mats);
        
        for(int k = mats.length-1; k>=0; k--){
            int size = mats[k];
            
            for(int i=0; i<park.length; i++){
                for(int j=0; j<park[i].length; j++){
                    if(park[i][j].equals("-1")&&canPlaceMat(park, size,i,j)){
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
    
    // 해당 사이즈의 돗자리를 깔 수 있는지 확인
    boolean canPlaceMat(String[][] arr, int size, int a, int b){ 
        boolean check = true;
        int row = arr.length;
        int col = arr[0].length;
        
        if (a + size > row || b + size > col) {return false;}

        for(int i=a; i<a+size; i++){
             for(int j=b; j<b+size; j++){
                if(!arr[i][j].equals("-1")){
                    return false;
                }
            }
        }
    
        return check;
    }
}