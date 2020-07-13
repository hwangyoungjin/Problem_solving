package day11;

//주민번호 검사 문제

public class day1103 {

	public static void main(String[] args) {

		String jumin = "890101-2012932";
		// 문제 1) 나이 출력
		// 정답 1) 30세
		
		// 문제 2) 성별 출력
		// 정답 2) 여성
		
		int year = (2020-Integer.valueOf(19+jumin.substring(0,2))+1);
		System.out.println("jumin님의 나이는 : "+ year);
		
		/** or
		 * char key = jumin.charAt(7);
		 * if(key == '1' || key == '3') {
		 * 	System.out.println("남성");
		 * }
		 * else if(key == '2' || key == '4') {
		 * 	System.out.println("여성");
		 * } 
		 */
		int gender = Integer.valueOf(jumin.charAt(7)+"");
		if(gender == 1) {
			System.out.println("jumin님의 성별은 남자입니다.");
		}
		else if(gender == 2) {
			System.out.println("jumin님의 성별은 여자입니다.");
		}
		
	}
}