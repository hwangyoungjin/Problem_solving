package java_jungsuk3_PracticeProblem;


/**
 * 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
메서드명 : delChar
기 능 : 주어진 문자열에서 금지된 문자들을 제거하여 반환한다.
반환타입 : String
매개변수 : String src - 변환할 문자열, String delCh - 제거할 문자들로 구성된 문자열
 * @author USER
 *
 */
public class Exercise9_9 {
	/*
	(1) delChar메서드를 작성하시오.
	*/
	static String delChar(String src, String delCh) {
		StringBuffer buf = new StringBuffer(src.length());
		
		int check;
		//src에 제거할 문자가 있다면 pass 하고 없다면 buf에 저장
		for(int i=0; i<src.length(); i++) {
			check = -1;
			for(int j=0; j<delCh.length(); j++) {
				if(src.charAt(i) == delCh.charAt(j)) {
					check = 1;
				}
			}
			if(check != 1) { // src.charAt(i)가 제거할 문자가 아니라면
				buf.append(src.charAt(i)); // buf에 추가
			}
		}
		return buf.toString(); // buffer 내용 String으로 변환
	}
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)"+" -> "
		+ delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)"+" -> "
		+ delChar("(1 2 3 4\t5)"," \t"));
	}
}
