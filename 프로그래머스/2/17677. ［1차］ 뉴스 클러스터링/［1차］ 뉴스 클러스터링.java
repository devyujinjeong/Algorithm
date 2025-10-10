import java.util.*;

class Solution {
    
    static final int mod = 65536;
    
    public int solution(String str1, String str2) {
        int a = 0;
        int b = 0;
        int answer = 0;
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        // 1. 1번째, 2번째 문자열의 2개 문자를 저장하기 위한 HashMap
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
 
        // 2. HashMap에 각각의 문자와 그 개수 저장하기
        // 대소문자 구분이 없으니 다 대문자로 저장하기
        // 영문자만 유효하기 때문에 영문자가 아니면 다 버리기
        for(int i=0; i<len1-1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);

            if(!isAlpha(c1) || !isAlpha(c2)) continue; 
            
            String s1 = "" + c1 + c2;
            String s2 = s1.toUpperCase();
            map1.put(s2, map1.getOrDefault(s2,0)+1);
        }

        for(int i=0; i<len2-1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);

            if(!isAlpha(c1) || !isAlpha(c2)) continue; 
            
            String s1 = "" + c1 + c2;
            String s2 = s1.toUpperCase();
            map2.put(s2, map2.getOrDefault(s2,0)+1);
        }
        
        // 3. 교집합, 합집합 구하기
        for(String key : map2.keySet()) {
            if(map1.containsKey(key)) {
                a += Math.min(map1.get(key), map2.get(key)); // 교집합
                b += Math.max(map1.get(key), map2.get(key)); // 합집합 (겹치는)
            }
        }
        
        // 4. 겹치지 않는 합집합 구하기
        for(String key : map2.keySet()) {
            if(!map1.containsKey(key)) {
                b += map2.get(key);
            }
        }
        
        for(String key : map1.keySet()) {
            if(!map2.containsKey(key)) {
                b += map1.get(key);
            }
        }

        if(a==0 && b==0) answer = mod;
        else answer = a * mod / b;
        
        return answer;
    }
    
    // 알파벳인지 아닌지를 판단하는 메소드
    static boolean isAlpha(char a) {
        int temp = (int)a;
        if(65<=temp && temp<=90) {
            return true;
        } else if(97<=temp && temp<=122) {
            return true;
        }
        
        return false;
    }
}