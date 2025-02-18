import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        
        HashSet<Integer> pokemon = new HashSet<Integer>();
        for(int i=0; i<len; i++){
            pokemon.add(nums[i]);
        }
        
        if(pokemon.size()>len/2){
            answer = len/2;
        }else{
            answer = pokemon.size();
        }
        
        return answer;
    }
}