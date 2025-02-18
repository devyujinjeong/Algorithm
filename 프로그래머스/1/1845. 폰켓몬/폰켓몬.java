import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        
        HashSet<Integer> phonekemon = new HashSet<Integer>();
        for(int i=0; i<len; i++){
            phonekemon.add(nums[i]);
        }
        
        if(phonekemon.size()>len/2){
            answer = len/2;
        }else{
            answer = phonekemon.size();
        }
        
        return answer;
    }
}