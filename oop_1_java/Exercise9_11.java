package java_jungsuk3_PracticeProblem;

import java.util.Scanner;

/**
 * 커맨드라인으로 2~9사이의 두 개의 숫자를 받아서 두 숫자사이의 구구단을 출력하는 프로그램을 작성하시오.
 * 예를 들어 3과 5를 입력하면 3단부터 5단까지 출력한다
 * @author USER
 *
 */
public class Exercise9_11 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("2~9사이의 숫자 2개 입력 입력 : ");
		
		int gu1=0; 
		int gu2=0;
		try {
			String input = scan.nextLine();
			String str[] = input.split(" ");
			if(str.length != 2) {
				throw new Exception("2개의 숫자만 입력해주세요 ( 띄어쓰기 필수 ) ");
			}
			gu1 = Integer.parseInt(String.valueOf(str[0]));
			gu2 = Integer.parseInt(String.valueOf(str[1]));
			
			if(gu1 <2 || gu2 > 9 ) {
				throw new Exception("숫자 범위 2~9를 입력해주세요");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		
		}
		
		
		for(int i=gu1; i<=gu2; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i+"*"+j+" = "+ i*j);
			}
			System.out.println();
		}
	}	
}
