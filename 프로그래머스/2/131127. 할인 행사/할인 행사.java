import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {  
        int answer = 0;
        HashMap<String, Integer> products = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            products.put(want[i], number[i]);
        }
        
        for(int i=0; i<=discount.length-10; i++){
            HashMap<String, Integer> tempMap = new HashMap<>(products);
            int count = 0;
            for(int j=i; j<i+10; j++){
                String item = discount[j];
                if(tempMap.containsKey(item)&&tempMap.get(item)>0){
                    tempMap.put(item, tempMap.get(item)-1);
                    count++;
                }
            }
            
            if(count==10) {
                answer++;
            }
        }
        
        return answer;
    }
}