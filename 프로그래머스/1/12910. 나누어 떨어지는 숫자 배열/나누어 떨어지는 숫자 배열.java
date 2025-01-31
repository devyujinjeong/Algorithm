import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        int len = arr.length;
        ArrayList<Integer> num = new ArrayList<Integer>();
        
        for(int i=0; i<len; i++){
            if(arr[i]%divisor==0){
                num.add(arr[i]);
            }
        }
        
        if(num.size()==0){
            num.add(-1);
        }else{
            Collections.sort(num);
        }
        
        return num;
    }
}