import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    
    // 시작 => 레버, 레버 => 출구
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        Node start = null, lever = null, end = null;
        
        // 시작, 레버, 끝 위치 찾기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j) == 'S') {
                    start = new Node(i,j);
                } else if(maps[i].charAt(j) == 'L'){
                    lever = new Node(i,j);
                } else if(maps[i].charAt(j) =='E') {
                    end = new Node(i,j);
                }
            }
        }
        
        int startToLever = bfs(maps, start, lever);
        int leverToEnd = bfs(maps, lever, end);
        
        if(startToLever == -1 || leverToEnd == -1) {
            return -1;
        } else{
            return startToLever + leverToEnd;
        }
    }
    
    public int bfs(String[] maps, Node start, Node end) {
        int[][] miro = new int[n][m];
        
        miro[start.x][start.y] = 1;
        
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            Node temp = q.poll();
            
            int tempx = temp.x;
            int tempy = temp.y;
            
            for(int i=0; i<4; i++){
                int x = tempx + dx[i];
                int y = tempy + dy[i];
                       
                // 범위에서 벗어나지 않아야 함
                if(x<0 || x>=n || y<0 || y>=m) continue;
                
                // 벽이 아니어야 함
                if(maps[x].charAt(y) == 'X') continue;
                
                // 이미 지나간 곳은 다시 탐색하지 않음
                if(miro[x][y] != 0) continue;
                
                // 최단 거리에 +1 추가하기
                miro[x][y] = miro[tempx][tempy] + 1;
                        
                // q에 node 추가하기
                q.add(new Node(x,y));
                        
                // 만약 끝점을 만나면 해당 위치까지 저장된 값을 반환하기
                if(x == end.x && y == end.y) {
                    return miro[x][y] - 1;
                }  
            }
        }      
        
        return -1;
    }
}

class Node {
    int x;
    int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    } 
}