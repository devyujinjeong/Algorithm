import java.util.*;

class Solution {
    public  ArrayList<Integer> solution(String s) {
        // {{, }} 자르기
        s = s.substring(2,s.length()-2);
        String[] arr = s.split("},\\{");  
        
        // 길이를 기준으로 정렬하기
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (String group : arr) {
            String[] numbers = group.split(",");
            for (String num : numbers) {
                int value = Integer.parseInt(num);
                if (!result.contains(value)) {
                    result.add(value);
                }
            }
        }
        
        return result;
    }
}
