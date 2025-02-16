import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int k, int[] score) {
        ArrayList<Integer> answer = new  ArrayList<Integer>();
        PriorityQueue<Integer> pq = new  PriorityQueue<Integer>();
        
        for(int i=0; i<score.length; i++){
            pq.add(score[i]);
            if(pq.size()>k){
                pq.poll();
            }
            answer.add(pq.peek());
        }
        return answer;
    }
}