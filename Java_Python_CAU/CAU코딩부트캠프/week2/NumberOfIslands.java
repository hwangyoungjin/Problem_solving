package week2;

/**
 * 섬의 개수 찾기
 * 
 * 예제) 
 * [“1”, “1”, “1”, “1”, “0”], 
 * [“1”, “1”, “0”, “1”, “0”], 
 * [“1”, “1”, “0”,“0”, “0”], 
 * [“0”, “0”, “0”, “0”, “0”] 
 * 이러한 배열이 있을때 1을 제외 하고는 모두 바다입니다. 
 * 이때 섬의 개수를 찾으십시오.(단 괄호는 모두 바다로 생각해도 좋습니다.)
 * 
 * 위 예제는 섬이 하나입니다.
 * 
 * @author USER
 *
 */
public class NumberOfIslands {

	//동 -> 남 -> 서 -> 북
	static int direction[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static boolean visitCheck[][] = new boolean[][] { { false, false, false, false, false },
													{ false, false, false, false, false }, 
													{ false, false, false, false, false },
													{ false, false, false, false, false } };

	//동남서북 순서로 탐색
	static void search(String[][] island, int curX, int curY) {
		// 해당 위치 방문
		visitCheck[curY][curX] = true;
		
		for (int i = 0; i < direction.length; i++) {
			int nextX = curX + direction[i][1];
			int nextY = curY + direction[i][0];

			
			// 다음 위치에 대해서 범위 초과x 
			if(0<= nextX && 0<= nextY && nextX < island[0].length && nextY < island.length) {
				//방문하지 않았고, 섬이라면
				if (visitCheck[nextY][nextX] == false
					&& island[nextY][nextX].equals("1")) {
					// 다음 위치에서 다시 검사
					search(island, nextX, nextY);
				} // if end
			} // if end
 		} // for end
	}

	public static void main(String[] args) {
		//섬이 6개인 배열
		String[][] island1 = new String[][]{{"1", "1", "0", "1", "0"},
			{"1", "1", "0", "0", "1"},
			{"0", "0", "1", "0", "0"},
			{"1", "1", "0", "1", "1"}};
			
		int islandCount = 0; // 존재하는 섬 개수
		
		//섬 개수  탐색
		for(int y=0; y<island1.length; y++) {
			for(int x=0; x<island1[0].length; x++) {
				//방문하지 않았고, 1이면
				if(visitCheck[y][x]==false && island1[y][x].equals("1")) { 
					islandCount++;
					search(island1,x,y);
				}
			}
		}
		System.out.println("island1 의 섬 개수는 : "+islandCount+"개 입니다.");	
	}
}
