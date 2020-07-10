package java_jungsuk3_PracticeProblem;
/**
 * 아래 세 개의 클래스로부터 공통부분을 뽑아서 Unit이라는 클래스를 만들고, 
 * 이클래스를 상속받도록 코드를 변경하시오
 * @author USER
 *
 */
abstract class Unit{ // 추상메서드가 1개 있으므로 추상클래스
	int x, y; // 현재 위치
	abstract void move(int x, int y); //추상메서드 /* 지정된 위치로 이동 */ 
	void stop() { /* 현재 위치에 정지 */ }
}

class Marine1 extends Unit{ // 보병
	void move(int x, int y) {}
	void stimPack() { /* 스팀팩을 사용한다.*/}
}
class Tank extends Unit{ // 탱크
	void move(int x, int y) {}
	void changeMode() { /* 공격모드를 변환한다. */}
}
class Dropship extends Unit{ // 수송선
	void move(int x, int y) {}
	void load() { /* 선택된 대상을 태운다.*/ }
	void unload() { /* 선택된 대상을 내린다.*/ }
}

public class Exercise7_17 {
	public static void main(String[] args) {
		
	}
}
