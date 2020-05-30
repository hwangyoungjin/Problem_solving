package java_jungsuk3_PracticeProblem;

//6_9~ : 모든 병사의 공격력과 방어력은 같아야 한다.

class Marine{
	int x=0, y=0; // 위치좌표
	int hp = 60; // 현재 체력
 	static int weapon = 6; // 공격력
 	static int armor = 0; // 방어력
	
 	// static 변수에 대해 작업을 하는 메서드
	static void weaponUp() {
		weapon++;
	}
	//static 변수에 대해 작업을 하는 메서드
	static void armorUp() {
		armor++;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Exercise6_9 {
	public static void main(String[] args) {
		
	}
}
