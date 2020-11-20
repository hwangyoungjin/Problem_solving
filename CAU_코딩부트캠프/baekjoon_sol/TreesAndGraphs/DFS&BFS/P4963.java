import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
               
        while(true){
            int w = scan.nextInt();
            int h = scan.nextInt();
            if(w==0 && h==0){
                break;
            }
            //해당 크기만큼 배열 생성
            int[][] island = new int[h][w];
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    island[i][j] = scan.nextInt();
                }
            }
            //해당 크기만큼 방문 배열 생성 false로 초기화
            boolean[][] visit = new boolean[h][w];
            
            int countIsland = 0;
            
            //0,0 부터 값이 1이고 방문 안했으면 탐색
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(visit[i][j] == false && island[i][j] == 1){
                        dfs(island,visit,i,j,w,h);
                        countIsland++;
                    }
                }
            }
            //섬의 개수 출력
            System.out.println(countIsland);
        }
    }
    
    public static void dfs(int[][] island, boolean[][] visit, int y, int x, int w, int h){
        visit[y][x] = true;
        //System.out.println("현재 위치 x : "+x+", y : "+y);
        int nextY = 0;
        int nextX = 0;
        //동, 동남, 남, 남서, 서, 서북, 북, 북동
        int[][] direction = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};        
        
        for(int i=0; i<direction.length; i++){
            nextY = y + direction[i][0]; //다음 이동할 위치
            nextX = x + direction[i][1];
            //동, 동남, 남, 남서, 서, 서북, 북, 북동에 대해서 방문안했고 범위안에 있고 섬이 있으면
            if(nextY >= 0 && nextY<h && nextX >= 0 && nextX < w && visit[nextY][nextX] == false && island[nextY][nextX] == 1){
                dfs(island,visit,nextY,nextX,w,h); // 재귀 탐색
            }
        }
    }
}