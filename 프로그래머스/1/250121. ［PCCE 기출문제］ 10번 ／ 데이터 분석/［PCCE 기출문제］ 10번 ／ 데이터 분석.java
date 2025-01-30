import java.util.*;
class Solution {
    public ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {   
        ArrayList<int[]> answer = new ArrayList<int[]>();
        
        String[] datas = {"code", "date", "maximum", "remain"};
        int temp = 0;
        
        for(int i=0; i<4; i++){
            for(int j=0; j<data.length; j++){
                if(datas[i].equals(ext)){
                    if(data[j][i]<val_ext){
                        answer.add(data[j]);
                    }
                }
            }
            
            if(datas[i].equals(sort_by)){
                temp = i;
            }
        }
        
        final int index = temp;
        Collections.sort(answer,(o1,o2)->o1[index]-o2[index]);
        
        return answer;
    }
}