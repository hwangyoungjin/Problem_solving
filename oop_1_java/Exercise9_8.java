package java_jungsuk3_PracticeProblem;

/**
 * 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 * 메서드명 : round
 * 기 능 : 주어진 값을 반올림하여, 소수점 이하 n자리의 값을 반환한다.
 * 예를 들어 n의 값이 3이면, 소수점 4째 자리에서 반올림하여 소수점 이하 3자리의수를 반환한다.
 * 반환타입 : double
 * 매개변수 : double d - 변환할 값, int n - 반올림한 결과의 소수점 자리
 * @author USER
 *
 */
public class Exercise9_8 {
	/*
	(1) round메서드를 작성하시오.
	*/
	static double round(double d, int n) {
		/*
		 * int num =1; for(int i = 0; i<n; i++) { num *=10; } return
		 * (double)Math.round(d*num)/num;
		 */
		return Math.round(d*Math.pow(10, n))/Math.pow(10, n);
		
	}
	public static void main(String[] args) {
		System.out.println(round(3.1415,1));
		System.out.println(round(3.1415,2));
		System.out.println(round(3.1415,3));
		System.out.println(round(3.1415,4));
		System.out.println(round(3.1415,5));
	}
}
