package java_jungsuk3_PracticeProblem;

/**
 * 메서드명 : action
 * 기 능 : 주어진 객체의 메서드를 호출한다.
 * DanceRobot인 경우, dance()를 호출하고,
 * SingRobot인 경우, sing()을 호출하고,
 * DrawRobot인 경우, draw()를 호출한다.
 * 반환타입 : 없음
 * 매개변수 : Robot r - Robot인스턴스 또는 Robot의 자손 인스턴스
 * @author USER
 *
 */
public class Exercise7_18 {
	
	
	static void action(Robot r) { // Robot인스턴스 또는 Robot의 자손 인스턴스
		if(r instanceof DanceRobot) { // danceRobot 객체 or 그 이하 자손객체라면
			DanceRobot dan = (DanceRobot)r; // 리모콘 개수 추가
			dan.dance(); // 
		}
		else if(r instanceof SingRobot) {
			SingRobot sing = (SingRobot)r; // 리모콘 개수 추가
			sing.sing();
		}
		else if(r instanceof DrawRobot) {
			DrawRobot draw = (DrawRobot)r; // 리모콘 개수 추가
			draw.draw(); 
		}
	}
	
	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot()};
		for(int i=0; i< arr.length;i++) {
			action(arr[i]);	
		}
	} // main
}


class Robot {}

class DanceRobot extends Robot {
	void dance() {
	System.out.println("춤을 춥니다.");
	}
}
class SingRobot extends Robot {
	void sing() {
	System.out.println("노래를 합니다.");
	}
}
class DrawRobot extends Robot {
	void draw() {
	System.out.println("그림을 그립니다.");
	}
}

