package backjoon.dfs;

import java.util.*;

//DFS 단지수별로 오름차순 정렬해서 출력
public class P2667{

    static int homeNum = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //지도 크기
        int[][] apart = new int[n][n];

        String[] number  = new String[n];
        for(int i=0; i<n; i++){
            number[i] = sc.next();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               apart[i][j] = (number[i].charAt(j)-'0');
            }
        }

        System.out.println(Arrays.deepToString(apart));

        //방문체크 -> false로 자동 초기화
        boolean[][] visit = new boolean[n][n];

        //단지마다 존재하는 집의 수
        List<Integer> homeList = new ArrayList<>();



        for(int y=0; y<n; y++){
            for(int x=0; x<n; x++){
                if(visit[y][x] == false && apart[y][x] == 1){
                    homeNum = 0;
                    dfs(y,x,n,apart,visit);
                    homeList.add(homeNum);
                }
            }
        }

        Collections.sort(homeList);
        System.out.println(homeList.size());
        for(int num : homeList){
            System.out.println(num);
        }
    }

    static void dfs(int curY, int curX, int n, int[][] apart, boolean[][] visit){
        visit[curY][curX] = true;
        homeNum++; //home 수 추가

        //동, 남, 서, 북 방향으로 탐색
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

        int nextY,nextX;
        for(int i=0; i<direction.length; i++){
            nextY = curY+direction[i][0];
            nextX = curX+direction[i][1];
            if(nextY>=0 && nextY <n
                    && nextX>=0 && nextX<n
                    && visit[nextY][nextX] == false
                    && apart[nextY][nextX] == 1){
                dfs(nextY,nextX,n, apart, visit);
            }
        }
    }

}
