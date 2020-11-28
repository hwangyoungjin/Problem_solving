package beakjoon;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Position{
	int x;
	int y;

	Position(){}
	Position(int y, int x, int day){
		this.y = y;
		this.x = x;
	}
	
	
}

public class Main { //Graph없이 bfs만 사용
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		int[][] map = new int[n][m]; 
		ArrayList<Position> list = new ArrayList<>();
		int check=0;//입력값 받기 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j] == 1) {//익은 토마토이면 시작위치이므로 list에 추가
					Position position = new Position(); //다른객체이므로 바로 생성
					position.y=i;
					position.x=j;
					list.add(position);
				}
			}
		}
		//System.out.println(Arrays.deepToString(visit));
		
		//bfs - 최소 날짜 : 출력
		System.out.println(bfs(map,list,m,n));
		
	}
	
	public static int bfs(int[][] map, ArrayList<Position> list, int m, int n) {
		int day = 0;
//		for(Position pos : list) {
//			System.out.println("시작포지션 -> y : "+pos.y+", x : " +pos.x+", day : "+pos.day);
//		}
		//init
		//각 포지션의 방문은 이미main에서 수행
		Queue<Position> queue = new LinkedList<>();
		//시작 position개수만큼 queue 추가
		for(int i=0; i<list.size(); i++) {
			queue.add(list.get(i));
		}
		
		
		//동 남 서 북 순서로 {y,x}
		int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
		
		Position position;
		
		while(!queue.isEmpty()) {
			position = queue.poll(); //queue에서 한놈 뽑아서
			
			//System.out.println("방문 위치 y : "+position.y+", x : "+position.x +", day : "+position.day);
			
			//queue에서 뽑은 한놈을 기준으로 동남서북 탐색
			for(int i=0; i<4; i++) {
				int nextY = position.y + direction[i][0];
				int nextX = position.x + direction[i][1];
				//동남서북 순서로 방문 안했고 막힌길이 아니라면
				if(nextY > -1 && nextY < n && nextX > -1 && nextX <m && map[nextY][nextX] == 0) {
					//indexoutofboundsexception를 피하기 위해 visit검사는 뒤로
					Position nextPosition = new Position();
					nextPosition.y = nextY;
					nextPosition.x = nextX;
					
					day = map[position.y][position.x];
					map[nextY][nextX] = map[position.y][position.x]+1;
					queue.add(nextPosition); //queue에 저장
				}
			}
		}
		
		//bfs 후 방문 안한곳이 하나라도 있으면 -1
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					return -1;
				}
			}
		}
		//모두다 방문했으면 day
		return day;
	}

}
