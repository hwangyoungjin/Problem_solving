package test3;

import java.util.Scanner;

/**
 * 문자열 A와 정수N을 입력받아 다음의 규칙대로 문자열 A를 변경하고 그 결과 출력
 * 
 * 문자	변경규칙
 * 대문자	해당 대문자로부터 아스키 코드표 순서로 N번쨰 뒤 문자
 * 소문자	해당 소문자로부터 아스키 코드표 순서로 N번쨰 앞 문자
 * 숫자	해당 숫자 번째의 알파벳 대문자를 N번 반복
 * 그 외	공백으로 변경
 * 
 * - 문자열의 길이 최대 20
 * - 정수는 1이상 10이하
 * - 문자열 A에 존재하는 숫자는 0보다 크고 27보다 작다
 * 예)
 * 문자 : CLikp5tGLE?Qej15J2, 숫자 N : 2 - > ENginEErING 
 * @author USER
 *
 */
public class StringConverter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("문자 : ");
		String str = scan.nextLine();
		System.out.print("정수 N(1이상 10이하) : ");
		int n = scan.nextInt();
		System.out.println("변환 후 문자 : " + converter(str,n));
	}
	
	//문자와 숫자를 받아 규칙에따라 문자 변환
	static StringBuffer converter(String str, int n) {
		StringBuffer buf = new StringBuffer();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i); //문자열 하나하나 검사
			if(ch >= 'A' && ch <= 'Z') { //대문자인 경우
				char alp = (char)(ch+n);
				buf.append(alp);
			}
			else if(ch >= 'a' && ch <= 'z') { //소문자인 경우
				char alp = (char)(ch-n);
				buf.append(alp);
			}
			else if(ch >= '0' && ch <= '9') { //숫자인 경우 (1~26)
				//숫자값 저장하고 
				int num = ch-'0'; //숫자값 넣기 
				
				//다음 번째값 받아서 
				char ch2 = str.charAt(i+1);
				//숫자인지 검사
				if(ch2 >= '0' && ch2 <= '9') {//숫자라면
					//검사했으므로 i+1
					i++; 
					// 숫자 더하기 (앞에서 num은 10의 자리이므로 *10)
					num = (ch2-'0') + (num*10);
				}
				
				//해당  숫자 번쨰의 알파벳구하기 (A의 아스키코드=65)
				char alp = (char)(65+num-1); 
				
				for(int j=0; j<n; j++) { //n번 반복
					buf.append(alp);
				}
			}
			else { //그 외 공백
				buf.append(" ");
			}
			
		}
		return buf;
	}
	
}
