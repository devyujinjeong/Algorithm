import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        s = s.substring(1, s.length()-2);
        s = s.replace("{", "");
        
        String[] num = s.split("},");

        Arrays.sort(num, (a,b) -> (a.length() - b.length()));
                
        for(int i=0; i<num.length; i++){
            String[] nums = num[i].split(",");
            for(int j=0; j<nums.length; j++){
                int temp = Integer.parseInt(nums[j]);
                if(!answer.contains(temp)) {
                    answer.add(temp);
                }
            }
        }
        
        return answer;
    }
}