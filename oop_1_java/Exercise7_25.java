package java_jungsuk3_PracticeProblem;

/**
 * 내부클래스
 * @author USER
 *
 */

class Outer {
	class Inner {
		int iv=100;
		}
}

class Outer1 {
	static class Inner1 {
		int iv=200;
	}
}

class Outer2 {
	int value = 10;
	class Inner2 {
		int value = 20;
		void method1() {
			int value = 30;
			System.out.println(value); // 30 출력
			System.out.println(this.value); // 20 출력
			System.out.println(Outer2.this.value); // 10 출력 
			// 외부클래스이름.this.변수이름 - 외부클래스의 인스턴스 변수 선언 구별방법
		}
	}//Inner2 class
}// Outer2 class

public class Exercise7_25 {
	public static void main(String[] args) {
		Outer o = new Outer(); // 외부클래스 인스턴스 생성 
		Outer.Inner ii = o.new Inner(); // 외부클래스의 인스턴스를 이용하여 내부클래스 인스턴스 생성
		System.out.println(ii.iv);
	
		System.out.println();
		/*-------------------------------------------------------*/
		System.out.println();
		
		
		Outer1.Inner1 ic = new Outer1.Inner1(); // Outer1의 static 멤버인 Inner1은 인스턴스 생성 필요x
		// 그러나 Inner1의 멤버 iv는 static이 아니므로 인스턴스 생성 필요
		System.out.println(ic.iv);

		
		System.out.println();
		/*-------------------------------------------------------*/
		System.out.println();
		
		
		Outer2 o2 = new Outer2(); // 외부 클래스 인스턴스 생성 
		Outer2.Inner2 in = o2.new Inner2(); // 외부클래스 인스턴스를 이용하여 내부클래스 인스턴스 생성
		in.method1(); // 내부클래스의 메서드 실행
	}
}
