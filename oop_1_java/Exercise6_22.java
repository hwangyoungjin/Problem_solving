package java_jungsuk3_PracticeProblem;

/*숫자 확인 메서드 만들기*/
//주어진 문자열이 모두 숫자로만 이루어져 있는지 확인
//모두 숫자이면 true 아니면 false
//문자열이 null이거나 빈 문자열이면 false
public class Exercise6_22 {
	
	static boolean isNumber(String str) {
		if(str == null || str == "") {
			return false;
		}
		else {
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i); // 0~부터 index 하나씩 문자 받기
				if(ch - '0' < 0 || ch-'0' > 9 ) {
					//한번이라도 숫자가 아니라면 false 반환
					return false;				
				}
			}	
			return true;
		}
	}	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"는 숫자입니까? "+ isNumber(str));
		
		str = "1234o";
		System.out.println(str+"는 숫자입니까? "+ isNumber(str));
	}
}
