package week2;
/**
 * 고인 물의양 계산하기
 * 
 * 예제)
 * 지형
 * [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * 
 * 담길 수 있는 물의 양 6
 * 
 * @author USER
 *
 */
public class CatchingRainwater {
	//지형 배열
	int terrain[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; 
	
	//최고 높이 찾기
	static int top(int terrain[]) {
		int height = 0;
		for(int i=0; i<terrain.length; i++) {
			if(height<terrain[i]) {
				height = terrain[i];
			}
		}
		return height;
	}
	
	//지형출력
	static void print(int terrain[]) {
		int height = top(terrain);
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<terrain.length; j++) {
				if((height - terrain[j]) <= i) {
					System.out.print("■ ");
				}
				else {
					System.out.print("□ ");
				}
			}
			System.out.println();
		}
	}
	
	//왼쪽 채우기
	static void left(int terrain[]) {
		int height = top(terrain);
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<terrain.length; j++) {
				if(terrain[j-1]==height) {
					break;
				}
				if((height - terrain[j]) <= i) {
					System.out.print("■ ");
				}
				else {
					System.out.print("□ ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		CatchingRainwater cr = new CatchingRainwater();
		System.out.println("최고 높이는 : "+ top(cr.terrain));
		print(cr.terrain);
		System.out.println();
		System.out.println();
		left(cr.terrain);
	}
}
